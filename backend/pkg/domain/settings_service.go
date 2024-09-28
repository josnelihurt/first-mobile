package domain

import (
	"context"

	"github.com/josnelihurt/first-mobile/backend/pkg/entities"
)

type settingsService struct {
	repo settingsRepositoryInterface
}

func NewSettingsService(repo settingsRepositoryInterface) *settingsService {
	return newSettingsService(repo)
}

func newSettingsService(repo settingsRepositoryInterface) *settingsService {
	return &settingsService{
		repo: repo,
	}
}

func (s *settingsService) GetServicesSettings(ctx context.Context) (entities.ServicesSettings, error) {
	return s.repo.GetServicesSettings(ctx)
}
