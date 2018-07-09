package learn;

import java.io.File;
import java.util.Objects;

/**
 * @author Created By Frank
 * @date 2018-07-09 10:32
 */
public class test {

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            listAllFiles(file);
        }
    }

    public static void main(String[] args) {
        File dir = new File("D:/#必备软件");
        listAllFiles(dir);


    }
}
