package com.josnelihurt.mobile_api_stub.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: mobile-api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MobileAPIServiceGrpc {

  private MobileAPIServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "josnelihurt.mobile_api_stub.gen.MobileAPIService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.InfoRequest,
      com.josnelihurt.mobile_api_stub.gen.InfoResponse> getInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Info",
      requestType = com.josnelihurt.mobile_api_stub.gen.InfoRequest.class,
      responseType = com.josnelihurt.mobile_api_stub.gen.InfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.InfoRequest,
      com.josnelihurt.mobile_api_stub.gen.InfoResponse> getInfoMethod() {
    io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.InfoRequest, com.josnelihurt.mobile_api_stub.gen.InfoResponse> getInfoMethod;
    if ((getInfoMethod = MobileAPIServiceGrpc.getInfoMethod) == null) {
      synchronized (MobileAPIServiceGrpc.class) {
        if ((getInfoMethod = MobileAPIServiceGrpc.getInfoMethod) == null) {
          MobileAPIServiceGrpc.getInfoMethod = getInfoMethod =
              io.grpc.MethodDescriptor.<com.josnelihurt.mobile_api_stub.gen.InfoRequest, com.josnelihurt.mobile_api_stub.gen.InfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Info"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.josnelihurt.mobile_api_stub.gen.InfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.josnelihurt.mobile_api_stub.gen.InfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAPIServiceMethodDescriptorSupplier("Info"))
              .build();
        }
      }
    }
    return getInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.BootRequest,
      com.josnelihurt.mobile_api_stub.gen.BootResponse> getBootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Boot",
      requestType = com.josnelihurt.mobile_api_stub.gen.BootRequest.class,
      responseType = com.josnelihurt.mobile_api_stub.gen.BootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.BootRequest,
      com.josnelihurt.mobile_api_stub.gen.BootResponse> getBootMethod() {
    io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.BootRequest, com.josnelihurt.mobile_api_stub.gen.BootResponse> getBootMethod;
    if ((getBootMethod = MobileAPIServiceGrpc.getBootMethod) == null) {
      synchronized (MobileAPIServiceGrpc.class) {
        if ((getBootMethod = MobileAPIServiceGrpc.getBootMethod) == null) {
          MobileAPIServiceGrpc.getBootMethod = getBootMethod =
              io.grpc.MethodDescriptor.<com.josnelihurt.mobile_api_stub.gen.BootRequest, com.josnelihurt.mobile_api_stub.gen.BootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Boot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.josnelihurt.mobile_api_stub.gen.BootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.josnelihurt.mobile_api_stub.gen.BootResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAPIServiceMethodDescriptorSupplier("Boot"))
              .build();
        }
      }
    }
    return getBootMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest,
      com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse> getStreamSMSMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamSMS",
      requestType = com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest.class,
      responseType = com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest,
      com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse> getStreamSMSMethod() {
    io.grpc.MethodDescriptor<com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest, com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse> getStreamSMSMethod;
    if ((getStreamSMSMethod = MobileAPIServiceGrpc.getStreamSMSMethod) == null) {
      synchronized (MobileAPIServiceGrpc.class) {
        if ((getStreamSMSMethod = MobileAPIServiceGrpc.getStreamSMSMethod) == null) {
          MobileAPIServiceGrpc.getStreamSMSMethod = getStreamSMSMethod =
              io.grpc.MethodDescriptor.<com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest, com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamSMS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAPIServiceMethodDescriptorSupplier("StreamSMS"))
              .build();
        }
      }
    }
    return getStreamSMSMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MobileAPIServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAPIServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAPIServiceStub>() {
        @java.lang.Override
        public MobileAPIServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAPIServiceStub(channel, callOptions);
        }
      };
    return MobileAPIServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MobileAPIServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAPIServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAPIServiceBlockingStub>() {
        @java.lang.Override
        public MobileAPIServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAPIServiceBlockingStub(channel, callOptions);
        }
      };
    return MobileAPIServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MobileAPIServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAPIServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAPIServiceFutureStub>() {
        @java.lang.Override
        public MobileAPIServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAPIServiceFutureStub(channel, callOptions);
        }
      };
    return MobileAPIServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void info(com.josnelihurt.mobile_api_stub.gen.InfoRequest request,
        io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.InfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInfoMethod(), responseObserver);
    }

    /**
     */
    default void boot(com.josnelihurt.mobile_api_stub.gen.BootRequest request,
        io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.BootResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBootMethod(), responseObserver);
    }

    /**
     */
    default void streamSMS(com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest request,
        io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamSMSMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MobileAPIService.
   */
  public static abstract class MobileAPIServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MobileAPIServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MobileAPIService.
   */
  public static final class MobileAPIServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MobileAPIServiceStub> {
    private MobileAPIServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAPIServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAPIServiceStub(channel, callOptions);
    }

    /**
     */
    public void info(com.josnelihurt.mobile_api_stub.gen.InfoRequest request,
        io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.InfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void boot(com.josnelihurt.mobile_api_stub.gen.BootRequest request,
        io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.BootResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBootMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamSMS(com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest request,
        io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamSMSMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MobileAPIService.
   */
  public static final class MobileAPIServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MobileAPIServiceBlockingStub> {
    private MobileAPIServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAPIServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAPIServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.josnelihurt.mobile_api_stub.gen.InfoResponse info(com.josnelihurt.mobile_api_stub.gen.InfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.josnelihurt.mobile_api_stub.gen.BootResponse boot(com.josnelihurt.mobile_api_stub.gen.BootRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBootMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse> streamSMS(
        com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamSMSMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MobileAPIService.
   */
  public static final class MobileAPIServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MobileAPIServiceFutureStub> {
    private MobileAPIServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAPIServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAPIServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.josnelihurt.mobile_api_stub.gen.InfoResponse> info(
        com.josnelihurt.mobile_api_stub.gen.InfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.josnelihurt.mobile_api_stub.gen.BootResponse> boot(
        com.josnelihurt.mobile_api_stub.gen.BootRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBootMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INFO = 0;
  private static final int METHODID_BOOT = 1;
  private static final int METHODID_STREAM_SMS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INFO:
          serviceImpl.info((com.josnelihurt.mobile_api_stub.gen.InfoRequest) request,
              (io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.InfoResponse>) responseObserver);
          break;
        case METHODID_BOOT:
          serviceImpl.boot((com.josnelihurt.mobile_api_stub.gen.BootRequest) request,
              (io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.BootResponse>) responseObserver);
          break;
        case METHODID_STREAM_SMS:
          serviceImpl.streamSMS((com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest) request,
              (io.grpc.stub.StreamObserver<com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.josnelihurt.mobile_api_stub.gen.InfoRequest,
              com.josnelihurt.mobile_api_stub.gen.InfoResponse>(
                service, METHODID_INFO)))
        .addMethod(
          getBootMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.josnelihurt.mobile_api_stub.gen.BootRequest,
              com.josnelihurt.mobile_api_stub.gen.BootResponse>(
                service, METHODID_BOOT)))
        .addMethod(
          getStreamSMSMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.josnelihurt.mobile_api_stub.gen.StreamSMSRequest,
              com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse>(
                service, METHODID_STREAM_SMS)))
        .build();
  }

  private static abstract class MobileAPIServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MobileAPIServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.josnelihurt.mobile_api_stub.gen.MobileApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MobileAPIService");
    }
  }

  private static final class MobileAPIServiceFileDescriptorSupplier
      extends MobileAPIServiceBaseDescriptorSupplier {
    MobileAPIServiceFileDescriptorSupplier() {}
  }

  private static final class MobileAPIServiceMethodDescriptorSupplier
      extends MobileAPIServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MobileAPIServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MobileAPIServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MobileAPIServiceFileDescriptorSupplier())
              .addMethod(getInfoMethod())
              .addMethod(getBootMethod())
              .addMethod(getStreamSMSMethod())
              .build();
        }
      }
    }
    return result;
  }
}
