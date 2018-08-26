package sword_offer.code10_斐波那契数列系列.跳台阶;

public class Solution1_递归方法 {
    public static int JumpFloor(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int count = JumpFloor(target-1)+JumpFloor(target-2);
        return count;

    }
}