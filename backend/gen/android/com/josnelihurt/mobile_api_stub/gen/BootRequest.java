// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: mobile-api.proto
// Protobuf Java Version: 4.28.2

package com.josnelihurt.mobile_api_stub.gen;

/**
 * Protobuf type {@code josnelihurt.mobile_api_stub.gen.BootRequest}
 */
public final class BootRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:josnelihurt.mobile_api_stub.gen.BootRequest)
    BootRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      BootRequest.class.getName());
  }
  // Use BootRequest.newBuilder() to construct.
  private BootRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private BootRequest() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.josnelihurt.mobile_api_stub.gen.MobileApiProto.internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.josnelihurt.mobile_api_stub.gen.MobileApiProto.internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.josnelihurt.mobile_api_stub.gen.BootRequest.class, com.josnelihurt.mobile_api_stub.gen.BootRequest.Builder.class);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.josnelihurt.mobile_api_stub.gen.BootRequest)) {
      return super.equals(obj);
    }
    com.josnelihurt.mobile_api_stub.gen.BootRequest other = (com.josnelihurt.mobile_api_stub.gen.BootRequest) obj;

    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.josnelihurt.mobile_api_stub.gen.BootRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.josnelihurt.mobile_api_stub.gen.BootRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code josnelihurt.mobile_api_stub.gen.BootRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:josnelihurt.mobile_api_stub.gen.BootRequest)
      com.josnelihurt.mobile_api_stub.gen.BootRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.josnelihurt.mobile_api_stub.gen.MobileApiProto.internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.josnelihurt.mobile_api_stub.gen.MobileApiProto.internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.josnelihurt.mobile_api_stub.gen.BootRequest.class, com.josnelihurt.mobile_api_stub.gen.BootRequest.Builder.class);
    }

    // Construct using com.josnelihurt.mobile_api_stub.gen.BootRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.josnelihurt.mobile_api_stub.gen.MobileApiProto.internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_descriptor;
    }

    @java.lang.Override
    public com.josnelihurt.mobile_api_stub.gen.BootRequest getDefaultInstanceForType() {
      return com.josnelihurt.mobile_api_stub.gen.BootRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.josnelihurt.mobile_api_stub.gen.BootRequest build() {
      com.josnelihurt.mobile_api_stub.gen.BootRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.josnelihurt.mobile_api_stub.gen.BootRequest buildPartial() {
      com.josnelihurt.mobile_api_stub.gen.BootRequest result = new com.josnelihurt.mobile_api_stub.gen.BootRequest(this);
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.josnelihurt.mobile_api_stub.gen.BootRequest) {
        return mergeFrom((com.josnelihurt.mobile_api_stub.gen.BootRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.josnelihurt.mobile_api_stub.gen.BootRequest other) {
      if (other == com.josnelihurt.mobile_api_stub.gen.BootRequest.getDefaultInstance()) return this;
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    // @@protoc_insertion_point(builder_scope:josnelihurt.mobile_api_stub.gen.BootRequest)
  }

  // @@protoc_insertion_point(class_scope:josnelihurt.mobile_api_stub.gen.BootRequest)
  private static final com.josnelihurt.mobile_api_stub.gen.BootRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.josnelihurt.mobile_api_stub.gen.BootRequest();
  }

  public static com.josnelihurt.mobile_api_stub.gen.BootRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BootRequest>
      PARSER = new com.google.protobuf.AbstractParser<BootRequest>() {
    @java.lang.Override
    public BootRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<BootRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BootRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.josnelihurt.mobile_api_stub.gen.BootRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

