package thisisjava.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferdInputStreamExample {

    public static void main(String[] args) throws IOException {

        long start = 0;
        long end = 0;

        FileInputStream fis1 = new FileInputStream(
                FilePath.packagePath + "/forest.jpeg"
        );

        start = System.currentTimeMillis();
        while(fis1.read() != -1) {}
        end = System.currentTimeMillis();
        System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
        fis1.close();

        FileInputStream fis2 = new FileInputStream(
                FilePath.packagePath + "/forest.jpeg"
        );
        BufferedInputStream bis = new BufferedInputStream(fis2);

        start = System.currentTimeMillis();
        while(fis1.read() != -1) {}
        end = System.currentTimeMillis();
        System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
        bis.close();
        fis1.close();


    }
}
