package sword_offer.code7_重建二叉树; /**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 思路：前序遍历的第一个数是跟结点，在中序遍历中查找根节点，则根节点左边是其左子树，右边是其右子树；
 * 对应的根节点在中序遍历序列中的下标即为根节点左子树在前序遍历中的结点下标。同理，用递归的方法即可重建。
 * <p>
 */

import sword_offer.standard.TreeNode;

import java.util.Arrays;

public class Solution3 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == node.val) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
