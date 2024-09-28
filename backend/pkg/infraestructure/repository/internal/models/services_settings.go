package models

import (
	"net/url"

	"github.com/josnelihurt/first-mobile/backend/pkg/entities"
)

type ServicesSettings struct {
	AuthorizationServiceURL string `yaml:"authorization_service_url"`
	TokenServiceURL         string `yaml:"token_service_url"`
	ClientID                string `yaml:"client_id"`
}

func (s *ServicesSettings) ToEntity() (entities.ServicesSettings, error) {
	authorizationServiceURL, err := url.Parse(s.AuthorizationServiceURL)
	if err != nil {
		return entities.ServicesSettings{}, err
	}
	tokenServiceURL, err := url.Parse(s.TokenServiceURL)
	if err != nil {
		return entities.ServicesSettings{}, err
	}
	return entities.ServicesSettings{
		AuthorizationServiceURL: *authorizationServiceURL,
		TokenServiceURL:         *tokenServiceURL,
		ClientID:                s.ClientID,
	}, nil
}
