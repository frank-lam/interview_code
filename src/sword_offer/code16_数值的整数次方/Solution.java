package sword_offer.code16_数值的整数次方;

public class Solution {
    public static double Power(double base, int exponent) {
        double res = 1;
        if (exponent == 0) {
            return 1;
        }

        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res *= base;
            }
        } else { // < 0

            for (int i = 0; i < -exponent; i++) {
                res *= base;
            }
            res = 1 / res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }
}