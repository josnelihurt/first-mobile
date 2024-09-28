package domain

import (
	"context"

	"github.com/josnelihurt/first-mobile/backend/pkg/entities"
)

type settingsRepositoryInterface interface {
	GetServicesSettings(ctx context.Context) (entities.ServicesSettings, error)
}
