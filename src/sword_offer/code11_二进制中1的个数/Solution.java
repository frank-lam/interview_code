package sword_offer.code11_二进制中1的个数;

public class Solution {

    // 思路1：使用Integer函数库计算
    public static int NumberOf1_1(int n) {
        String bstr = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < bstr.length(); i++) {
            char ch = bstr.charAt(i);
            if (ch == '1') {
                res++;
            }
        }
        return res;
    }


    // 思路2：对n的二进制数的每一位都与1进行&运算，来计算1的个数
    public static int NumberOf1_2(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    // 思路3：一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
    //        原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
    public static int NumberOf1_3(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(NumberOf1_1(10));
        System.out.println(NumberOf1_2(10));
        System.out.println(NumberOf1_3(10));
    }
}