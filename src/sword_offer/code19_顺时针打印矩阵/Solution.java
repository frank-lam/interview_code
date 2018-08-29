package sword_offer.code19_顺时针打印矩阵;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (matrix == null) {
            return null;
        }
        if (matrix.length == 0) {
            return null;
        }

        int ysize = matrix.length;
        int xsize = matrix[0].length;
        int size = xsize > ysize ? ysize : xsize;
        size = size % 2 == 0 ? size / 2 : (size + 1) / 2; // 圈数


        for (int cicle = 0; cicle < size; cicle++) { // 这个循环是遍历圈数，cicle记录圈数
//            System.out.println("打印一圈");
            int start = cicle;
            int xend = xsize - 1 - cicle;
            int yend = ysize - 1 - cicle;

//            System.out.println("X begin at : " + cicle + ", xend :" + xend);
//            System.out.println("Y begin at : " + cicle + ", yend :" + yend);

//            if (start == xend && start == yend) {  // 这一步可以去除，在下面的 三个if中已经实现判断
//                resList.add(matrix[start][start]);
//            }

            if (xend - start == 0) { // 如果是一列
                for (int i = start; i <= yend; i++) {
                    resList.add(matrix[i][xend]);
                }
            } else if (yend - start == 0) { // 如果是一行
                for (int i = start; i <= xend; i++) {
                    resList.add(matrix[yend][i]);
                }

            } else {
                // 上边
                for (int i = start; i < xend; i++) {
//                    System.out.println("up add:" + matrix[start][i]);
                    resList.add(matrix[start][i]);
                }
                // 右边
                for (int i = start; i < yend; i++) {
//                    System.out.println("right add:" + matrix[i][xend]);
                    resList.add(matrix[i][xend]);
                }

                // 下边
                for (int i = xend; i > start; i--) {
//                    System.out.println("bottom add:" + matrix[yend][i]);

                    resList.add(matrix[yend][i]);
                }

                // 左边
                for (int i = yend; i > start; i--) {
//                    System.out.println("left add:" + matrix[i][start]);
                    resList.add(matrix[i][start]);
                }
            }


        }
        return resList;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] matrix3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] matrix4 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}
        };

        int[][] matrix5 = {
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4}
        };

        int[][] matrix6 = {
                {1},
                {2},
                {3}
        };

        int[][] matrix7 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        ArrayList<Integer> res = printMatrix(matrix3);
        System.out.println(res);

    }
}