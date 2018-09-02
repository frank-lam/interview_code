package sword_offer.code30_连续子数组的最大和;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int total = array[0];
        int maxsum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(total > 0){
                total += array[i];
            }
            else{
                total = array[i];
            }
            if(total > maxsum){
                maxsum = total;
            }
        }
        return maxsum;
    }

    public static void main(String[] args){
        System.out.println(new Solution().FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
    }
}