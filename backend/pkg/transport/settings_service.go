package transport

import (
	"context"

	"github.com/josnelihurt/first-mobile/backend/pkg/entities"
)

type settingsServiceInterface interface {
	GetServicesSettings(ctx context.Context) (entities.ServicesSettings, error)
}
