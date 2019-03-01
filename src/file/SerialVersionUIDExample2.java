package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialVersionUIDExample2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(
                "/Users/hanyoungjeong/Temp/Object.dat"
        );
        ObjectInputStream ois = new ObjectInputStream(fis);
        ClassC classC = (ClassC) ois.readObject();
        System.out.println("field1: " + classC.field1);
        System.out.println("field2: " + classC.field2);
        System.out.println("field3: " + classC.field3);
    }
}
