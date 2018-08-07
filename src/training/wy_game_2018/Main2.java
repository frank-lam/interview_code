package training.wy_game_2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Created By Frank
 * @date 2018-08-07 15:13
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(
                new FileReader("D:\\gitdoc\\interview_code\\src\\training\\wy_game_2018\\input2.txt")
        ));
        int n = in.nextInt();

        for (int k = 0; k < n; k++) {
            int count = in.nextInt();
            Set<Integer> set = new LinkedHashSet<>();

            for (int i = 0; i < count; i++) {
                int item = in.nextInt();
                if (set.contains(item)) {
                    set.remove(item);
                }
                set.add(item);
            }
            printReverseSet(set);
            if (k != n - 1) {
                System.out.println();
            }

        }
    }

    private static void printReverseSet(Set<Integer> set) {
        for (int i = set.size() - 1; i >= 0; i--) {
            System.out.print(set.toArray()[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }


}
