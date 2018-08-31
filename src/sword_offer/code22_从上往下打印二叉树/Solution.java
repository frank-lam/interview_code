package sword_offer.code22_从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> reslist = new ArrayList<>();
        if(root == null)
            return reslist;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (queue.isEmpty()) {
            queue.push(root);
        }
        while (!queue.isEmpty()) { // 只要左右子树不都为空的时候
            root = queue.pop();
            reslist.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return reslist;
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        //
        // 正确输出：8 6 10 5 7 9 11
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);
        head.right = new TreeNode(10);
        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);
        System.out.println(new Solution().PrintFromTopToBottom(null));

    }
}