package main

import (
	"context"
	"fmt"

	"github.com/josnelihurt/first-mobile/backend/pkg/application"
)

const appName = "mobile-api:"

func main() {
	fmt.Println(appName, "Starting ")

	ctx := context.Background()
	app := application.New(ctx)
	defer app.Stop()
	if err := app.Run(); err != nil {
		fmt.Println(appName, "Error ", err)
	}

	fmt.Println(appName, "Stopped")
}
