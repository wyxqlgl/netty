// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: student.proto

package com.myNetty.proto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_StudentResquest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_StudentResquest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_StudentResponseList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_StreamRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_StreamRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myNetty_proto_StreamResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myNetty_proto_StreamResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rstudent.proto\022\021com.myNetty.proto\"\036\n\017St" +
      "udentResquest\022\013\n\003age\030\001 \001(\005\":\n\017StudentRes" +
      "ponse\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\014\n\004city" +
      "\030\003 \001(\t\"\035\n\tMyRequest\022\020\n\010username\030\001 \001(\t\"\036\n" +
      "\nMyResponse\022\020\n\010realname\030\002 \001(\t\"R\n\023Student" +
      "ResponseList\022;\n\017studentResponse\030\001 \003(\0132\"." +
      "com.myNetty.proto.StudentResponse\"%\n\rStr" +
      "eamRequest\022\024\n\014request_info\030\001 \001(\t\"\'\n\016Stre" +
      "amResponse\022\025\n\rresponse_info\030\001 \001(\t2\210\003\n\016St" +
      "udentService\022V\n\025GetRealNameByUsername\022\034." +
      "com.myNetty.proto.MyRequest\032\035.com.myNett" +
      "y.proto.MyResponse\"\000\022^\n\020GetStudentsByAge" +
      "\022\".com.myNetty.proto.StudentResquest\032\".c" +
      "om.myNetty.proto.StudentResponse\"\0000\001\022i\n\027" +
      "GetStudentWrapperByAges\022\".com.myNetty.pr" +
      "oto.StudentResquest\032&.com.myNetty.proto." +
      "StudentResponseList\"\000(\001\022S\n\006BiTalk\022 .com." +
      "myNetty.proto.StreamRequest\032!.com.myNett" +
      "y.proto.StreamResponse\"\000(\0010\001B#\n\021com.myNe" +
      "tty.protoB\014StudentProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_myNetty_proto_StudentResquest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_myNetty_proto_StudentResquest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_StudentResquest_descriptor,
        new String[] { "Age", });
    internal_static_com_myNetty_proto_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_myNetty_proto_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_StudentResponse_descriptor,
        new String[] { "Name", "Age", "City", });
    internal_static_com_myNetty_proto_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_myNetty_proto_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_MyRequest_descriptor,
        new String[] { "Username", });
    internal_static_com_myNetty_proto_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_myNetty_proto_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_MyResponse_descriptor,
        new String[] { "Realname", });
    internal_static_com_myNetty_proto_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_myNetty_proto_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_StudentResponseList_descriptor,
        new String[] { "StudentResponse", });
    internal_static_com_myNetty_proto_StreamRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_myNetty_proto_StreamRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_StreamRequest_descriptor,
        new String[] { "RequestInfo", });
    internal_static_com_myNetty_proto_StreamResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_myNetty_proto_StreamResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_StreamResponse_descriptor,
        new String[] { "ResponseInfo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
