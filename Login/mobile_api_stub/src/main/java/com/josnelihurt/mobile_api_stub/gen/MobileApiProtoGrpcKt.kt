package com.josnelihurt.mobile_api_stub.gen

import com.josnelihurt.mobile_api_stub.gen.MobileAPIServiceGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * josnelihurt.mobile_api_stub.gen.MobileAPIService.
 */
public object MobileAPIServiceGrpcKt {
  public const val SERVICE_NAME: String = MobileAPIServiceGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val infoMethod: MethodDescriptor<InfoRequest, InfoResponse>
    @JvmStatic
    get() = MobileAPIServiceGrpc.getInfoMethod()

  public val bootMethod: MethodDescriptor<BootRequest, BootResponse>
    @JvmStatic
    get() = MobileAPIServiceGrpc.getBootMethod()

  public val streamSMSMethod: MethodDescriptor<StreamSMSRequest, StreamSMSResponse>
    @JvmStatic
    get() = MobileAPIServiceGrpc.getStreamSMSMethod()

  /**
   * A stub for issuing RPCs to a(n) josnelihurt.mobile_api_stub.gen.MobileAPIService service as
   * suspending coroutines.
   */
  @StubFor(MobileAPIServiceGrpc::class)
  public class MobileAPIServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<MobileAPIServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): MobileAPIServiceCoroutineStub =
        MobileAPIServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun info(request: InfoRequest, headers: Metadata = Metadata()): InfoResponse =
        unaryRpc(
      channel,
      MobileAPIServiceGrpc.getInfoMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun boot(request: BootRequest, headers: Metadata = Metadata()): BootResponse =
        unaryRpc(
      channel,
      MobileAPIServiceGrpc.getBootMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun streamSMS(request: StreamSMSRequest, headers: Metadata = Metadata()):
        Flow<StreamSMSResponse> = serverStreamingRpc(
      channel,
      MobileAPIServiceGrpc.getStreamSMSMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the josnelihurt.mobile_api_stub.gen.MobileAPIService service based
   * on Kotlin coroutines.
   */
  public abstract class MobileAPIServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for josnelihurt.mobile_api_stub.gen.MobileAPIService.Info.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun info(request: InfoRequest): InfoResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method josnelihurt.mobile_api_stub.gen.MobileAPIService.Info is unimplemented"))

    /**
     * Returns the response to an RPC for josnelihurt.mobile_api_stub.gen.MobileAPIService.Boot.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun boot(request: BootRequest): BootResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method josnelihurt.mobile_api_stub.gen.MobileAPIService.Boot is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * josnelihurt.mobile_api_stub.gen.MobileAPIService.StreamSMS.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun streamSMS(request: StreamSMSRequest): Flow<StreamSMSResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method josnelihurt.mobile_api_stub.gen.MobileAPIService.StreamSMS is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MobileAPIServiceGrpc.getInfoMethod(),
      implementation = ::info
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MobileAPIServiceGrpc.getBootMethod(),
      implementation = ::boot
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = MobileAPIServiceGrpc.getStreamSMSMethod(),
      implementation = ::streamSMS
    )).build()
  }
}
