package sword_offer.code23_二叉搜索树的后序遍历序列;

public class Solution {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] sequence, int startIndex, int rootIndex) {
        if (startIndex > rootIndex)
            return true;
        int i = startIndex;
        while (i < rootIndex && sequence[i] < sequence[rootIndex]) {
            i++;
        }
        for (int j = i; j < rootIndex; j++) {
            if (sequence[j] < sequence[rootIndex])
                return false;
        }
        return verify(sequence, startIndex, i - 1) && verify(sequence, i, rootIndex - 1);
    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] squence = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + VerifySquenceOfBST(squence));

        int[] squence6 = {7, 4, 6, 5};
        System.out.println("false: " + VerifySquenceOfBST(squence6));
    }
}