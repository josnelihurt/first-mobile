// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: mobile-api.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.josnelihurt.mobile_api_stub.gen;

@kotlin.jvm.JvmName("-initializestreamSMSResponse")
public inline fun streamSMSResponse(block: com.josnelihurt.mobile_api_stub.gen.StreamSMSResponseKt.Dsl.() -> kotlin.Unit): com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse =
  com.josnelihurt.mobile_api_stub.gen.StreamSMSResponseKt.Dsl._create(com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `josnelihurt.mobile_api_stub.gen.StreamSMSResponse`
 */
public object StreamSMSResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse = _builder.build()

    /**
     * `.josnelihurt.mobile_api_stub.gen.SMSMessage message = 1 [json_name = "message"];`
     */
    public var message: com.josnelihurt.mobile_api_stub.gen.SMSMessage
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * `.josnelihurt.mobile_api_stub.gen.SMSMessage message = 1 [json_name = "message"];`
     */
    public fun clearMessage() {
      _builder.clearMessage()
    }
    /**
     * `.josnelihurt.mobile_api_stub.gen.SMSMessage message = 1 [json_name = "message"];`
     * @return Whether the message field is set.
     */
    public fun hasMessage(): kotlin.Boolean {
      return _builder.hasMessage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse.copy(block: `com.josnelihurt.mobile_api_stub.gen`.StreamSMSResponseKt.Dsl.() -> kotlin.Unit): com.josnelihurt.mobile_api_stub.gen.StreamSMSResponse =
  `com.josnelihurt.mobile_api_stub.gen`.StreamSMSResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val com.josnelihurt.mobile_api_stub.gen.StreamSMSResponseOrBuilder.messageOrNull: com.josnelihurt.mobile_api_stub.gen.SMSMessage?
  get() = if (hasMessage()) getMessage() else null

