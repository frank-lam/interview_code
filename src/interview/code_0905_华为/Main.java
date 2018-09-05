package interview.code_0905_华为;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();

        if(line1.length()<=line2.length()){
            System.out.println(false);
            return;
        }


        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < line1.length(); i++) {
            set.add(line1.charAt(i));
        }


        int count = 0;
        for (int i = 0; i < line2.length(); i++) {
            char ch = line2.charAt(i);
            if(set.contains(ch)){
                count++;
            }
        }
        if(count == line2.length()){
            System.out.println(true);
        }

        else{
            System.out.println(false);
        }

    }

}
