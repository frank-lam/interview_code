package sword_offer.code18_二叉树的镜像;

/**
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 思路：先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
 *      当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
 */
public class Solution {
    public static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null  && root.right == null){
            return;
        }



        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;


        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        Mirror(root);
        TreeNodePrint.preTraverse(root);
    }
}