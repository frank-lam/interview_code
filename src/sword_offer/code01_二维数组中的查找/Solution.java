package sword_offer.code01_二维数组中的查找;

/**
 * @author Created By Frank
 * @date 2018-08-23 9:01
 * 二维数组中的查找
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println(new Solution().Find(10, array));
    }
}