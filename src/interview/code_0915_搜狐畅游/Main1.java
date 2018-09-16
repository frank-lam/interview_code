package interview.code_0915_搜狐畅游;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        HashSet<Integer> set = new HashSet<>();
        for(String item : line.split(" ")){
            int num = Integer.valueOf(item);
            if(set.contains(num)){
                System.out.println(num);
                break;
            }
            else{
                set.add(num);
            }
        }
    }
}
