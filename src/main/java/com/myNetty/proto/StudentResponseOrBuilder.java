// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: student.proto

package com.myNetty.proto;

public interface StudentResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.myNetty.proto.StudentResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 2;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>string city = 3;</code>
   * @return The city.
   */
  String getCity();
  /**
   * <code>string city = 3;</code>
   * @return The bytes for city.
   */
  com.google.protobuf.ByteString
      getCityBytes();
}
