package interview.code_0907_阿里巴巴;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0907_阿里巴巴\\input2.txt")));
        String xy = in.nextLine();
        int x = Integer.valueOf(xy.split(",")[0]);
        int y = Integer.valueOf(xy.split(",")[1]);

        String points = in.nextLine();


        String[] shape = points.split(",");
        int size = shape.length;
        int[] xarr = new int[size/2];
        int[] yarr = new int[size/2];

        for (int i = 0,index = 0; i < size ; i = i + 2,index++) {
            xarr[index] = Integer.valueOf(shape[i]);
            yarr[index] = Integer.valueOf(shape[i + 1]);
        }


        // 正方形
        if (size / 2 == 4) {

            int x_left = xarr[0];
            int x_right = xarr[3];
            int y_bottom = yarr[0];
            int y_top = yarr[1];

//            System.out.println(x + "," + y);
            if (x >= x_left && x <= x_right && y <= y_top && y >= y_bottom) {
                System.out.println("yes," + 0);
            } else {

                int toXRay = Math.min(Math.abs(y - y_bottom), Math.abs(y - y_top));
                int toYRay = Math.min(Math.abs(x - x_left), Math.abs(x - x_right));
                double len = Math.sqrt(toXRay*toXRay+toYRay*toYRay);


                if (x > x_right || x < x_left) {
                    if (y > y_top || y < y_bottom) {
                        System.out.println("no," + (Math.round(len)));
                    }
                    if (y <= y_top && y >= y_bottom) {
                        System.out.println("no," + toYRay);
                    }
                }
                if (y > y_top || y < y_bottom) {
                    if (x >= x_left && x <= x_right) {
                        System.out.println("no," + toXRay);
                    }
                }

            }
        } else {
            System.out.println("yes," + 0);
        }


    }

}
