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

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rstudent.proto\022\021com.myNetty.proto\"\036\n\017St" +
      "udentResquest\022\013\n\003age\030\001 \001(\005\":\n\017StudentRes" +
      "ponse\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\014\n\004city" +
      "\030\003 \001(\t\"\035\n\tMyRequest\022\020\n\010username\030\001 \001(\t\"\036\n" +
      "\nMyResponse\022\020\n\010realname\030\002 \001(\t2\310\001\n\016Studen" +
      "tService\022V\n\025GetRealNameByUsername\022\034.com." +
      "myNetty.proto.MyRequest\032\035.com.myNetty.pr" +
      "oto.MyResponse\"\000\022^\n\020GetStudentsByAge\022\".c" +
      "om.myNetty.proto.StudentResquest\032\".com.m" +
      "yNetty.proto.StudentResponse\"\0000\001B#\n\021com." +
      "myNetty.protoB\014StudentProtoP\001b\006proto3"
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
        new java.lang.String[] { "Age", });
    internal_static_com_myNetty_proto_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_myNetty_proto_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_StudentResponse_descriptor,
        new java.lang.String[] { "Name", "Age", "City", });
    internal_static_com_myNetty_proto_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_myNetty_proto_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_MyRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_com_myNetty_proto_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_myNetty_proto_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myNetty_proto_MyResponse_descriptor,
        new java.lang.String[] { "Realname", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}