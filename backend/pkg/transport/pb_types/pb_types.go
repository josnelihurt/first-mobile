package pb

import (
	"context"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	pb "github.com/josnelihurt/first-mobile/backend/gen/go/v1"
	"google.golang.org/grpc"
)

type BootRequest = pb.BootRequest
type BootResponse = pb.BootResponse
type InfoRequest = pb.InfoRequest
type InfoResponse = pb.InfoResponse
type StreamSMSRequest = pb.StreamSMSRequest
type StreamSMSResponse = pb.StreamSMSResponse

type ServicesSettings = pb.ServicesSettings
type SMSMessage = pb.SMSMessage

type UnimplementedMobileAPIServiceServer = pb.UnimplementedMobileAPIServiceServer
type MobileAPIServiceServer = pb.MobileAPIServiceServer

func RegisterMobileAPIServiceHandler(ctx context.Context, mux *runtime.ServeMux, conn *grpc.ClientConn) error {
	return pb.RegisterMobileAPIServiceHandler(ctx, mux, conn)
}

func RegisterMobileAPIServiceServer(s grpc.ServiceRegistrar, srv MobileAPIServiceServer) {
	pb.RegisterMobileAPIServiceServer(s, srv)
}
