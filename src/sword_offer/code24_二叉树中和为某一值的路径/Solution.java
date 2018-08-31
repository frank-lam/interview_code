package sword_offer.code24_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        Stack<Integer> stack = new Stack<>();
        findPath(root, target, pathList, stack);
        return pathList;
    }

    public static void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> pathList, Stack<Integer> stack) {
        if (root == null)
            return;
        stack.push(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {// 为叶子节点
            ArrayList<Integer> list = new ArrayList<>();
            for (int s : stack)
                list.add(s);
            pathList.add(list);
        }

        //不是叶子节点则遍历子节点
        if (root.left != null)
            findPath(root.left, target, pathList, stack);

        if (root.right != null)
            findPath(root.right, target, pathList, stack);

        //保证退出访问节点时要出栈！
        stack.pop();
    }


    public static void main(String[] args){
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(7);
        head.right = new TreeNode(12);
        // 有两条路径上的结点和为22
        System.out.println("findPath(head, 22);");
        System.out.println(FindPath(head, 22));
    }
}