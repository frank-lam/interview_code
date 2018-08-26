package sword_offer.code10_斐波那契数列系列.变态跳台阶;

public class Solution_递归方式 {

    public static int JumpFloorII(int target) {
        if(target<=2){
            return target;
        }

        int count = 0;
        for (int i = 1; i < target; i++) {
            count += JumpFloorII(target - i);
        }
        return count + 1;
    }


    public static int JumpFloorII2(int target) {
        int [] array = new int[target+1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i <= target; i++) {
            array[i] = 2 * array[i-1];
        }
        return array[target];
    }

    public static void main(String[] args) {

        System.out.println(JumpFloorII(10));
        System.out.println(JumpFloorII2(10));
    }
}