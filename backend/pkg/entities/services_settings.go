package entities

import "net/url"

type ServicesSettings struct {
	AuthorizationServiceURL url.URL
	TokenServiceURL         url.URL
	ClientID                string
}
