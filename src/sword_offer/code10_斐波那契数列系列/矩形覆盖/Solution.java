package sword_offer.code10_斐波那契数列系列.矩形覆盖;

public class Solution {
    public int RectCover(int target) {
        if(target <= 2){
            return target;
        }
        else{
            return RectCover(target-1) + RectCover(target-2);
        }
    }

    public static void main(String[] args){

    }
}