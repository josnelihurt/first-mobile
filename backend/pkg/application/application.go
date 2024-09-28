package application

import (
	"context"
	"fmt"
	"log"
	"net"
	"net/http"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"github.com/josnelihurt/first-mobile/backend/pkg/domain"
	"github.com/josnelihurt/first-mobile/backend/pkg/infraestructure/repository"
	"github.com/josnelihurt/first-mobile/backend/pkg/transport"
	pb "github.com/josnelihurt/first-mobile/backend/pkg/transport/pb_types"
	"google.golang.org/grpc"
)

type app struct {
	appCtx     context.Context
	httpServer *http.Server
	grpcServer *grpc.Server
}

func New(ctx context.Context) *app {
	app := &app{
		appCtx: ctx,
	}
	settingsRepository := repository.NewSettingsRepository()
	settingsService := domain.NewSettingsService(settingsRepository)
	serviceServer := transport.NewMobileAPIServiceServer(settingsService)

	var opts []grpc.ServerOption
	app.grpcServer = grpc.NewServer(opts...)
	pb.RegisterMobileAPIServiceServer(app.grpcServer, serviceServer)

	return app
}

func (app *app) Run() error {
	grpcLis, err := net.Listen("tcp", fmt.Sprintf("localhost:%d", 50051))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	go app.grpcServer.Serve(grpcLis)

	grpcConn, err := transport.NewGRPCConn()
	if err != nil {
		panic(err)
	}

	mux := runtime.NewServeMux()
	err = pb.RegisterMobileAPIServiceHandler(app.appCtx, mux, grpcConn)
	if err != nil {
		panic(err)
	}

	app.httpServer = transport.NewHttpServer(mux)

	httpLis, err := net.Listen("tcp", fmt.Sprintf("192.168.10.50:%d", 8080))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	app.httpServer.Serve(httpLis)
	return nil
}

func (a *app) Stop() error {
	return nil
}
