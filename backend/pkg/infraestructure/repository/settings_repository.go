package repository

import (
	"context"
	"os"
	"path/filepath"

	"github.com/go-yaml/yaml"
	"github.com/josnelihurt/first-mobile/backend/pkg/entities"
	"github.com/josnelihurt/first-mobile/backend/pkg/infraestructure/repository/internal/models"
)

type settingsRepository struct {
}

func NewSettingsRepository() *settingsRepository {
	return newSettingsRepository()
}

func newSettingsRepository() *settingsRepository {
	return &settingsRepository{}
}

func (r *settingsRepository) GetServicesSettings(ctx context.Context) (entities.ServicesSettings, error) {
	settings, err := r.loadSettingsFromFile(ctx, "data/config.yaml")
	if err != nil {
		return entities.ServicesSettings{}, err
	}
	entity, err := settings.ToEntity()
	if err != nil {
		return entities.ServicesSettings{}, err
	}

	return entity, nil
}

func (r *settingsRepository) loadSettingsFromFile(ctx context.Context, filePath string) (models.ServicesSettings, error) {
	absPath, err := filepath.Abs(filePath)
	if err != nil {
		return models.ServicesSettings{}, err
	}

	data, err := os.ReadFile(absPath)
	if err != nil {
		return models.ServicesSettings{}, err
	}

	var settings models.ServicesSettings
	err = yaml.Unmarshal(data, &settings)
	if err != nil {
		return models.ServicesSettings{}, err
	}

	return settings, nil
}
