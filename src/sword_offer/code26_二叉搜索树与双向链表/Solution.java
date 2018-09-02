package sword_offer.code26_二叉搜索树与双向链表;

/**
 * 二叉搜索树的中序遍历序列就是递增有序的
 */
public class Solution {
    //递归实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;

        // 将左子树构造成双链表，并返回链表头结点
        TreeNode pLeft = Convert(pRootOfTree.left);
        TreeNode pNode = pLeft;
        // 定位左子树链表的尾结点
        while (pNode != null && pNode.right != null)
            pNode = pNode.right;
        //左子树不为空，则将根节点加到左子树链表末尾
        if (pLeft != null) {
            pNode.right = pRootOfTree;
            pRootOfTree.left = pNode;
        }

        //将右子树构造成双链表，并返回链表头结点
        TreeNode pRight = Convert(pRootOfTree.right);
        //如果右子树链表不为空，则加到根节点后
        if (pRight != null) {
            pRootOfTree.right = pRight;
            pRight.left = pRootOfTree;
        }
        //根节点左子树链表不为空，则pLeft为链表头结点；否则根节点为链表头结点
        if (pLeft != null)
            return pLeft;
        return pRootOfTree;
    }

}