package thisisjava.file;

import java.io.FileInputStream;

public class FileInputStreamExample {

    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream(
                    "/Users/hanyoungjeong/Documents/java_workspace/java-practice/src/thisisjava.file/FileInputStreamExample.java"
            );

            int data;
            while((data = fis.read()) != -1) {
                System.out.write(data);
            }
            fis.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
