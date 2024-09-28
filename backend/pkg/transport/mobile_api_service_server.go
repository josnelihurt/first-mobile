package transport

import (
	"context"
	"fmt"
	"time"

	"github.com/google/uuid"
	"github.com/josnelihurt/first-mobile/backend/pkg/transport/internal"
	pb "github.com/josnelihurt/first-mobile/backend/pkg/transport/pb_types"
	"google.golang.org/grpc"
	"google.golang.org/protobuf/types/known/timestamppb"
)

type mobileAPIServiceServer struct {
	settingsService settingsServiceInterface
	pb.UnimplementedMobileAPIServiceServer
}

func NewMobileAPIServiceServer(settingsSvc settingsServiceInterface) *mobileAPIServiceServer {
	return &mobileAPIServiceServer{
		settingsService: settingsSvc,
	}
}

func (s *mobileAPIServiceServer) Boot(ctx context.Context, req *pb.BootRequest) (*pb.BootResponse, error) {
	request, err := internal.NewBootRequest().FromPB(req)
	if err != nil {
		return nil, err
	}
	if err := request.Validate(); err != nil {
		return nil, err
	}
	result, err := s.settingsService.GetServicesSettings(ctx)
	if err != nil {
		return nil, err
	}
	response, err := internal.NewBootResponse().FromEntities(result)
	if err != nil {
		return nil, err
	}
	if err := response.Validate(); err != nil {
		return nil, err
	}
	return response.ToPB(), nil
}

func (s *mobileAPIServiceServer) Info(context.Context, *pb.InfoRequest) (*pb.InfoResponse, error) {
	return &pb.InfoResponse{
		Status: "Ready",
	}, nil
}

func makeSMSMessage(recipient, message string) *pb.SMSMessage {
	return &pb.SMSMessage{
		Uuid:      uuid.New().String(),
		Timestamp: &timestamppb.Timestamp{},
		Message:   message,
		Sender:    "fake-sender",
		Recipient: recipient,
	}
}

func (s *mobileAPIServiceServer) StreamSMS(request *pb.StreamSMSRequest, serverStramingServer grpc.ServerStreamingServer[pb.StreamSMSResponse]) error {
	fmt.Printf("StreamSMS request received for phone number: %s\n", request.PhoneNumber)
	defer fmt.Printf("StreamSMS request for phone number: %s finished\n", request.PhoneNumber)
	ctx := serverStramingServer.Context()
	phoneNumber := request.PhoneNumber
	ticker := time.NewTicker(10 * time.Second)
	defer ticker.Stop()
	messageCount := 0

	for {
		select {
		case <-ctx.Done():
		default:
			fmt.Println("context done")
			return ctx.Err()

		case <-ticker.C:
			smsMessage := makeSMSMessage(phoneNumber, fmt.Sprintf("Message %d", messageCount))
			streamSMSResponse := &pb.StreamSMSResponse{Message: smsMessage}
			if err := serverStramingServer.Send(streamSMSResponse); err != nil {
				return err
			}
			messageCount++
		}
	}
}
