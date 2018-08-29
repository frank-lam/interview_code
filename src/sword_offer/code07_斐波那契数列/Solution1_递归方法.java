package sword_offer.code07_斐波那契数列;




public class Solution1_递归方法 {

    // 时间复杂度会特别大
    public static int Fibonacci(int n) {
        if( n == 0 )
            return 0;
        if( n == 1 )
            return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args){
        System.out.println(Fibonacci(3));
    }
}