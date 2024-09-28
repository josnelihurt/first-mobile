FROM golang:1.22-alpine as proto-builder
RUN go install github.com/bufbuild/buf/cmd/buf@latest
RUN go install github.com/grpc-ecosystem/grpc-gateway/v2/protoc-gen-grpc-gateway@latest
RUN go install github.com/grpc-ecosystem/grpc-gateway/v2/protoc-gen-openapiv2@latest
RUN go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@latest
RUN go install github.com/golang/protobuf/protoc-gen-go@latest
RUN go install github.com/chrusty/protoc-gen-jsonschema/cmd/protoc-gen-jsonschema@latest

FROM alpine:3.18.0
RUN apk add --update --no-cache \
    ca-certificates \
    git \
    protoc \
    openssh-client && \
  rm -rf /var/cache/apk/*
COPY --from=proto-builder /go/bin/buf /usr/local/bin/buf
COPY --from=proto-builder /go/bin/protoc-gen-go /usr/local/bin/protoc-gen-go-v2
COPY --from=proto-builder /go/bin/protoc-gen-grpc-gateway /usr/local/bin/protoc-gen-grpc-gateway
COPY --from=proto-builder /go/bin/protoc-gen-openapiv2 /usr/local/bin/protoc-gen-openapiv2
COPY --from=proto-builder /go/bin/protoc-gen-go-grpc /usr/local/bin/protoc-gen-go-grpc
COPY --from=proto-builder /go/bin/protoc-gen-go /usr/local/bin/protoc-gen-go-v1
COPY --from=proto-builder /go/bin/protoc-gen-go /usr/local/bin/protoc-gen-go
COPY --from=proto-builder /go/bin/protoc-gen-jsonschema /usr/local/bin/protoc-gen-jsonschema

ARG BUF_TOKEN
ENV BUF_TOKEN=${BUF_TOKEN}

WORKDIR /workdir
ENV XDG_CACHE_HOME=/workdir/.cache


ENTRYPOINT ["/usr/local/bin/buf"]