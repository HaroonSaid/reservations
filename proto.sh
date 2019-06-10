#!/bin/bash
export PROTOC="$HOME/.nuget/packages/google.protobuf.tools/3.8.0/tools/macosx_x64/protoc"
export OUT_DIR="./src/schema/"
export PROTO_LIB="$HOME/.nuget/packages/google.protobuf.tools/3.8.0/tools/"
#echo $PROTOC
#echo $PROTO_LIB
protoc --proto_path=$PROTO_LIB --proto_path=./src/schema/proto/ transaction.proto --csharp_out=$OUT_DIR/csharp --java_out=$OUT_DIR/java --java_out=$OUT_DIR/js 
