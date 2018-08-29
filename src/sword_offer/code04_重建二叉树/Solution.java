package sword_offer.code04_重建二叉树;

import sword_offer.standard.TreeNode;
import sword_offer.standard.TreeNodePrint;

import java.util.Arrays;

/**
 * @author Created By Frank
 * @date 2018-08-24 17:03
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (in[i] == root.val) {
                root.left  = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = new Solution().reConstructBinaryTree(pre, in);
        TreeNodePrint.preTraverse(root);
        TreeNodePrint.inTraverse(root);

    }

}
