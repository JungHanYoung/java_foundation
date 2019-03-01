package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialVersionUIDExample1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/hanyoungjeong/Temp/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ClassC classC = new ClassC();
        classC.field1 = 1;
        classC.field2 = 2;
        classC.field3 = 3;
        oos.writeObject(classC);
        oos.flush(); oos.close(); fos.close();
    }
}
