package data_structure.sort.quick_sort;

/**
 * @author Created By Frank
 * @date 2018-06-30 23:03
 */

import utils.SizeOf;

/**
 * 快速排序算法
 */
public class QuickSort {

    public static void main(String[] args) {
        Test test = new Test();
        Test2 test2 = new Test2();

        int a = 0;
        char ch = 'a';
        System.out.println("sizeof Integer:" + SizeOf.of(a));
        System.out.println("sizeof Character:" + SizeOf.of(ch));
        System.out.println("sizeof Test{int a;char b;int c;char d;}:" + SizeOf.of(test));
        System.out.println("sizeof Test{int a;int b;char c;char d;}:" + SizeOf.of(test2));

    }
}

class Test {
    int a;
    char b;
    int c;
    char d;
}

class Test2 {
    int a;
    int b;
    char c;
    char d;
}




