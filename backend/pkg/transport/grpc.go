package transport

import (
	"fmt"

	"google.golang.org/grpc"
)

func NewGRPCConn() (*grpc.ClientConn, error) {
	const serverAddr = "localhost:50051"
	conn, err := grpc.Dial(serverAddr, grpc.WithInsecure(), grpc.WithBlock())
	if err != nil {
		return nil, fmt.Errorf("Unable to dial %w", err)
	}
	return conn, nil
}
