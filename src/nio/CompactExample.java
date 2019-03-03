package nio;

import java.nio.ByteBuffer;

import static nio.MyBufferPrintUtils.printState;

public class CompactExample {

    public static void main(String[] args) {

        System.out.println("[7바이트 크기로 버퍼 생성]");
        ByteBuffer buffer = ByteBuffer.allocateDirect(7);
        buffer.put((byte)10);
        buffer.put((byte)11);
        buffer.put((byte)12);
        buffer.put((byte)13);
        buffer.put((byte)14);
        buffer.flip();
        printState(buffer);

        buffer.get(new byte[3]);
        System.out.println("[3바이트 읽음]");
        printState(buffer);

        buffer.compact();
        System.out.println("[compact() 실행후]");
        printState(buffer);
    }
}
