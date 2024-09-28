package internal

import (
	"fmt"

	"github.com/josnelihurt/first-mobile/backend/pkg/entities"

	pb "github.com/josnelihurt/first-mobile/backend/pkg/transport/pb_types"
)

type BootRequest struct{}

func NewBootRequest() BootRequest {
	return BootRequest{}
}

func (r BootRequest) FromPB(pb *pb.BootRequest) (BootRequest, error) {
	return BootRequest{}, nil
}

func (r BootRequest) Validate() error {
	return nil
}

type BootResponse struct {
	ServicesSettings entities.ServicesSettings
}

func NewBootResponse() BootResponse {
	return BootResponse{}
}

func (r BootResponse) FromEntities(settings entities.ServicesSettings) (BootResponse, error) {
	return BootResponse{
		ServicesSettings: settings,
	}, nil
}

func (r BootResponse) Validate() error {
	if r.ServicesSettings.ClientID == "" {
		return fmt.Errorf("ClientID is not set")
	}
	return nil
}

func (r BootResponse) ToPB() *pb.BootResponse {
	return &pb.BootResponse{
		Services: &pb.ServicesSettings{
			AuthorizationServiceUrl: r.ServicesSettings.AuthorizationServiceURL.String(),
			TokenServiceUrl:         r.ServicesSettings.TokenServiceURL.String(),
			ClientId:                r.ServicesSettings.ClientID,
		},
	}
}
