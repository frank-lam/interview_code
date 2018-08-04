package nowcoder.template;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-04 10:35
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // 这里设置输入输出文件，方便长出入调试使用
        Scanner in = new Scanner(new BufferedReader(new FileReader("xxx")));

    }

    private static void swap(int[] fighting, int i, int j) {
        int k = fighting[i];
        fighting[i] = fighting[j];
        fighting[j] = k;
    }


    // 打印arr数组的所有内容
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }


}
