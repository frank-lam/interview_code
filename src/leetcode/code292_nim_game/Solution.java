package leetcode.code292_nim_game;

/**
 * Nim游戏 - LeetCode (中国)
 * https://leetcode-cn.com/problems/nim-game/description/
 */

class Solution {
    public boolean canWinNim(int n) {
        if (n % 4 == 0)
            return false;
        return true;
    }
}