package learn;

import java.io.UnsupportedEncodingException;

/**
 * @author Created By Frank
 * @date 2018-07-04 15:08
 */
public class pass_by_value_and_reference {


    public static void main(String[] args) throws UnsupportedEncodingException {
        // Integer 是引用传递，不可变类
        Integer a = 1;
        Integer b = a;
        b++;
        System.out.println(" a: " + a);
        System.out.println(" b: " + b);

        StringBuffer s1 = new StringBuffer("Hello");
        StringBuffer s2 = new StringBuffer("Hello");
        changeStringBuffer(s1, s2);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println(Math.round(1.5));

        System.out.println(Integer.toBinaryString(10));


        String str1 = "Hello";
        String str2 = "你";
        System.out.println(str1.getBytes("GBK").length);
        System.out.println(str2.getBytes("GBK").length);

    }

    private static void changeStringBuffer(StringBuffer ss1, StringBuffer ss2) {
        ss1.append(" World");
        ss2 = ss1;
//        ss2 = new StringBuffer("12");
        ss2.reverse();


        short s1 = 1;
        s1 = (short) (s1 + 1);


    }
}
