package cn.edu.nju.seri;

import org.junit.Test;
import org.apache.jute.*;

import java.io.*;

/**
 * Created by thpffcj on 2019/9/6.
 */
public class StudentTest {

    @Test
    public void test() {
        Student student = new Student("Thpffcj", 8, 1);
        String path = "/Users/thpffcj/Public/data/javaser.txt";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------");

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
            Student obj = (Student) ois.readObject();
            System.out.println("obj = " + obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJute() throws Exception {
        Student student = new Student("Thpffcj", 8, 1);
        String path = "/Users/thpffcj/Public/data/jute.txt";

        OutputStream outputStream = new FileOutputStream(new File(path));
        InputStream inputStream = new FileInputStream(new File(path));

        BinaryOutputArchive binaryOutputArchive = BinaryOutputArchive.getArchive(outputStream);
        binaryOutputArchive.writeString(student.getUsername(), "username");
        binaryOutputArchive.writeInt(student.getAge(), "age");
        binaryOutputArchive.writeLong(student.getGrade(), "grade");

        outputStream.flush();
        outputStream.close();

        BinaryInputArchive binaryInputArchive = BinaryInputArchive.getArchive(inputStream);

        System.out.println("username = " + binaryInputArchive.readString("username"));
        System.out.println("username = " + binaryInputArchive.readInt("age"));
        System.out.println("username = " + binaryInputArchive.readLong("grade"));
    }
}