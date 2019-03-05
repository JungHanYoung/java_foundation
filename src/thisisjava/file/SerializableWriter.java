package thisisjava.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableWriter {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/hanyoungjeong/Temp/Object.dat");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ClassA classA = new ClassA();
        classA.field1 = 1;
        classA.field2.field1 = 2;
        ClassA.field3 = 3;
        classA.field4 = 4;

        oos.writeObject(classA);
        oos.flush(); oos.close(); fos.close();
    }
}