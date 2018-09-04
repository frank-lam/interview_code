package interview.code_0904_携程;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0904_携程\\input2.txt")));
        int n = in.nextInt();
        int checktime = in.nextInt();
//        int[] start = new int[n];
//        int[] end = new int[n];
        ArrayList<Integer> orders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int orderid = in.nextInt();
            int start = in.nextInt();
            int end = in.nextInt();
            if(checktime >= start && checktime <= end){
                orders.add(orderid);
            }
        }

        Collections.sort(orders);
        if(orders.size() == 0){
            System.out.print("null");
        }

        for (int i = 0; i < orders.size(); i++) {
            if(i != orders.size() -1){
                System.out.println(orders.get(i));
            }
            else{
                System.out.print(orders.get(i));
            }
        }
    }
}
