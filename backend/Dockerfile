FROM alpine:3.18.0
WORKDIR /app
COPY app.bin /app/app.bin
COPY cmd/mobile-app/config.yaml /app/config.yaml
CMD ["/app/app.bin"]