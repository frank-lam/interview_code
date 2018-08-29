package sword_offer.code17_树的子结构;

/**
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：第一步，先在树A中找到和B的根节点的值一样的结点R
 *		第二步，判断树A中以R为根节点的子树是不是包含和树B一样的结构。
 *
 * 实现：1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
 *		   剩下的代码不会执行，如果匹配不成功，默认返回false
 *		2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
 *		   如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 *		   再判断右子树和tree2是否相同
 *		3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
 *		   DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
 *		   tree1为空有两种情况
 *		 	1）如果tree1为空&&tree2不为空说明不匹配，
 *	        2）如果tree1为空，tree2为空，说明匹配。
 *
 */

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isSubTree(root1, root2);
            }
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;
        if (root2 == null)
            return true;
        if(root1.val != root2.val)
            return false;
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}