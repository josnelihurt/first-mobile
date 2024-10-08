// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: mobile-api.proto
// Protobuf Java Version: 4.28.2

package com.josnelihurt.mobile_api_stub.gen;

public final class MobileApiProto {
  private MobileApiProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      MobileApiProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_ServicesSettings_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_ServicesSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_SMSMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_SMSMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_InfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_InfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_InfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_InfoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_BootResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_BootResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020mobile-api.proto\022\037josnelihurt.mobile_a" +
      "pi_stub.gen\032\037google/protobuf/timestamp.p" +
      "roto\032\034google/api/annotations.proto\"\234\001\n\020S" +
      "ervicesSettings\022<\n\031authorization_service" +
      "_url\030\001 \001(\tR\031authorization_service_url\022,\n" +
      "\021token_service_url\030\003 \001(\tR\021token_service_" +
      "url\022\034\n\tclient_id\030\005 \001(\tR\tclient_id\"\252\001\n\nSM" +
      "SMessage\022\022\n\004uuid\030\001 \001(\tR\004uuid\0228\n\ttimestam" +
      "p\030\003 \001(\0132\032.google.protobuf.TimestampR\ttim" +
      "estamp\022\030\n\007message\030\005 \001(\tR\007message\022\026\n\006send" +
      "er\030\007 \001(\tR\006sender\022\034\n\trecipient\030\t \001(\tR\trec" +
      "ipient\"\r\n\013InfoRequest\"&\n\014InfoResponse\022\026\n" +
      "\006status\030\001 \001(\tR\006status\"\r\n\013BootRequest\"]\n\014" +
      "BootResponse\022M\n\010services\030\001 \001(\01321.josneli" +
      "hurt.mobile_api_stub.gen.ServicesSetting" +
      "sR\010services\"6\n\020StreamSMSRequest\022\"\n\014phone" +
      "_number\030\001 \001(\tR\014phone_number\"Z\n\021StreamSMS" +
      "Response\022E\n\007message\030\001 \001(\0132+.josnelihurt." +
      "mobile_api_stub.gen.SMSMessageR\007message2" +
      "\236\003\n\020MobileAPIService\022u\n\004Info\022,.josnelihu" +
      "rt.mobile_api_stub.gen.InfoRequest\032-.jos" +
      "nelihurt.mobile_api_stub.gen.InfoRespons" +
      "e\"\020\202\323\344\223\002\n\022\010/v1/info\022u\n\004Boot\022,.josnelihur" +
      "t.mobile_api_stub.gen.BootRequest\032-.josn" +
      "elihurt.mobile_api_stub.gen.BootResponse" +
      "\"\020\202\323\344\223\002\n\022\010/v1/boot\022\233\001\n\tStreamSMS\0221.josne" +
      "lihurt.mobile_api_stub.gen.StreamSMSRequ" +
      "est\0322.josnelihurt.mobile_api_stub.gen.St" +
      "reamSMSResponse\"%\202\323\344\223\002\037\022\035/v1/sms/stream/" +
      "{phone_number}0\001B\202\002\n#com.josnelihurt.mob" +
      "ile_api_stub.genB\016MobileApiProtoP\001Z5gith" +
      "ub.com/josnelihurt/first-mobile/backend/" +
      "gen/go/v1\242\002\003JMG\252\002\035Josnelihurt.MobileApiS" +
      "tub.Gen\312\002\035Josnelihurt\\MobileApiStub\\Gen\342" +
      "\002)Josnelihurt\\MobileApiStub\\Gen\\GPBMetad" +
      "ata\352\002\037Josnelihurt::MobileApiStub::Genb\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
        });
    internal_static_josnelihurt_mobile_api_stub_gen_ServicesSettings_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_josnelihurt_mobile_api_stub_gen_ServicesSettings_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_ServicesSettings_descriptor,
        new java.lang.String[] { "AuthorizationServiceUrl", "TokenServiceUrl", "ClientId", });
    internal_static_josnelihurt_mobile_api_stub_gen_SMSMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_josnelihurt_mobile_api_stub_gen_SMSMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_SMSMessage_descriptor,
        new java.lang.String[] { "Uuid", "Timestamp", "Message", "Sender", "Recipient", });
    internal_static_josnelihurt_mobile_api_stub_gen_InfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_josnelihurt_mobile_api_stub_gen_InfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_InfoRequest_descriptor,
        new java.lang.String[] { });
    internal_static_josnelihurt_mobile_api_stub_gen_InfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_josnelihurt_mobile_api_stub_gen_InfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_InfoResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_BootRequest_descriptor,
        new java.lang.String[] { });
    internal_static_josnelihurt_mobile_api_stub_gen_BootResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_josnelihurt_mobile_api_stub_gen_BootResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_BootResponse_descriptor,
        new java.lang.String[] { "Services", });
    internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSRequest_descriptor,
        new java.lang.String[] { "PhoneNumber", });
    internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_josnelihurt_mobile_api_stub_gen_StreamSMSResponse_descriptor,
        new java.lang.String[] { "Message", });
    descriptor.resolveAllFeaturesImmutable();
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
