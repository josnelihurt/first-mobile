package transport

import (
	"net/http"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
)

func NewHttpServer(mux *runtime.ServeMux) *http.Server {
	return &http.Server{
		Addr:    ":8080",
		Handler: mux,
	}
}
