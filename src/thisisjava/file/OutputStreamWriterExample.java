package thisisjava.file;

import java.io.*;

public class OutputStreamWriterExample {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("/Users/hanyoungjeong/Temp/thisisjava.file.txt");
        Writer writer = new OutputStreamWriter(fos);

        String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
        writer.write(data);

        writer.flush();
        writer.close();
        System.out.println("파일 저장이 끝났습니다.");
    }
}
