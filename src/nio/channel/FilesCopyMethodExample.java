package nio.channel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopyMethodExample {

    public static void main(String[] args) throws IOException {
        Path from = Paths.get("src/nio/house.jpeg");
        Path to = Paths.get("src/nio/channel/house1.jpeg");

        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("파일 복사 성공");
    }
}
