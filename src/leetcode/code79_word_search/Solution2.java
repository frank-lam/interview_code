package leetcode.code79_word_search;

/**
 * @author Created By Frank
 * @date 2018-08-07 16:48
 */

/**
 * 单词搜索 (Word Search) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/word-search/description/
 */
public class Solution2 {

    public int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 四个方向上的位移
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord2(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }



    // 从board[startx][starty]开始, 寻找word[index...word.size())
    private boolean searchWord2(char[][] board, String word, int index, int startx, int starty) {
        // 先写终止条件
        if (index == word.length() - 1)
            return board[startx][starty] == word.charAt(index);


        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
                for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if (searchWord2(board, word, index + 1, newx, newy))
                        return true;
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    // 判断点这是否在 范围内
    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String word1 = "ABCCSE";
//        boolean isWord1 = new Solution().exist(board, word1);
//        System.out.println(isWord1);
//
//        String word2 = "FF";
//        boolean isWord2 = new Solution().exist(board, word2);
//        System.out.println(isWord2);


        char[][] board = {
                {'A', 'A'},
        };
        String word1 = "AAAAAAA";
        boolean isWord1 = new Solution2().exist(board, word1);
        System.out.println(isWord1);

    }
}
