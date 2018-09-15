
package map;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.BinaryMessage;
import io.protostuff.runtime.RuntimeSchema;
import io.protostuff.LinkedBuffer;
//import io.protostuff.ProtostuffIOUtil;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import java.io.IOException;

public class WsPacket {
  
  public static synchronized boolean send(WebSocketSession session, String msg){
    // protobuf writing
/*    
    Schema<String> schema = RuntimeSchema.getSchema(String.class);    
    LinkedBuffer buffer = LinkedBuffer.allocate(512);
    final byte[] protostuff;
    try
    {
//        protostuff = ProtostuffIOUtil.toByteArray(msg, schema, buffer);
        protostuff = ProtobufIOUtil.toByteArray(msg, schema, buffer);
    }
    finally
    {
        buffer.clear();
    }
*/    
    
/*    var buffer = protobuf.Writer.create()
      .uint32((1 << 3 | 2) >>> 0) // id 1, wireType 2
      .string(msg)
      .finish();*/
    if (!session.isOpen()) {
      return false; 
    }
    try {
      session.sendMessage(new BinaryMessage(msg.getBytes())); 
      //session.sendMessage(new BinaryMessage(protostuff)); 
      //System.out.println("Sent: " + msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }
}