package grpc.java.server;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.google.protobuf.ByteString;

    public class Convertor {

      public static byte[] getBytes(UUID uuid) {
          ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
          bb.putLong(uuid.getMostSignificantBits());
          bb.putLong(uuid.getLeastSignificantBits());
          return bb.array();
      }
  
      public static UUID getUUIDFromBytes(byte[] bytes) {
          ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
          Long high = byteBuffer.getLong();
          Long low = byteBuffer.getLong();
          return new UUID(high, low);
      }
      public static ByteString toByteString(UUID uuid) {
        return ByteString.copyFrom(getBytes(uuid));
        }

    public static UUID fromByteString(ByteString byteString) {
        return getUUIDFromBytes(byteString.toByteArray());
    }
}