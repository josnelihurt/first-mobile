PROTO_DIR := $(realpath $(dir $(lastword $(MAKEFILE_LIST))))

build:
	go build -o app.bin ./cmd/mobile-api/main.go
	docker build -t mobile-api .

build-all: generate-protos build

build-bufgen-image:
	docker build --network host -t "bufgen-local" -f bufgen.dockerfile .

buf-update-deps:
	docker run --rm -u $(shell id -u):$(shell id -g) -v "$(PROTO_DIR):/workdir" --workdir /workdir bufgen-local dep update

buf-gen: 
	rm -rf $(PROTO_DIR)/../Login/mobile_api_stub/src/main/java/com/josnelihurt/mobile_api_stub/gen
	rm -rf gen/
	docker run --rm -u $(shell id -u):$(shell id -g) -v "$(PROTO_DIR):/workdir" --workdir /workdir --env-file ./secrets/buf_token_env bufgen-local generate -v --clean --template buf.gen.yaml
	
	cp -r $(PROTO_DIR)/gen/android/com/josnelihurt/mobile_api_stub/gen $(PROTO_DIR)/../Login/mobile_api_stub/src/main/java/com/josnelihurt/mobile_api_stub

buf-gen-it: 
	docker run -it --entrypoint /bin/sh --rm -u $(shell id -u):$(shell id -g) -v "$(shell pwd):/workdir" --workdir /workdir bufgen-local

install-swagger2openapi:
	npm install -g swagger2openapi

convert-swagger-locally:
	@if [ -z "$$(ls gen/openapi//.yaml 2>/dev/null)" ]; then \
		echo "No YAML files found in gen/openapi"; \
	else \
		for file in gen/openapi//.yaml; do \
			if echo $$file | grep -q '_messages'; then \
				echo "Skipping $$file"; \
			else \
				filename=$$(basename $$file); \
				echo "Converting $$file to ../docs/openapi/$$filename"; \
				swagger2openapi $$file -o ../docs/openapi/$$filename; \
			fi \
		done \
	fi

generate-swagger: generate-protos install-swagger2openapi
	make convert-swagger-locally
	go fmt ./...

lint:
	buf lint -v
