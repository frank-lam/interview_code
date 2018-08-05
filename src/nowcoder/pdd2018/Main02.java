package nowcoder.pdd2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-04 10:37
 */
public class Main02 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader("xxx")));
    }

    private static void swap(int[] fighting, int i, int j) {
        int k = fighting[i];
        fighting[i] = fighting[j];
        fighting[j] = k;
    }
}