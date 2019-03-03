package nio;

import java.nio.ByteBuffer;

public class MyBufferPrintUtils {

    public static void printState(ByteBuffer buffer) {
        System.out.print("\tposition: " + buffer.position() + ", ");
        System.out.print("\tlimit: " + buffer.limit() + ", ");
        System.out.print("\tcapacity: " + buffer.capacity());
        System.out.println();
    }
}
