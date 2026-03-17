package com.example.arithmetic;

/*
98. 验证二叉搜索树
中等
相关标签
相关企业
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


示例 1：
输入：root = [2,1,3]
输出：true

示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */

public class IsValidBSTTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(1);

        //222
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 前序遍历
    private static boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) return true;
        long x = (long) node.val;
        return left < x && x < right &&
                isValidBST(node.left, left, x) &&
                isValidBST(node.right, x, right);
    }

    public static boolean isValidBST2(TreeNode root, int rootVal) {
        if (root == null) return false;

        // 所有节点与根节点比较
//        int rootVal = root.val;
        while (root.left != null && root.right != null) {
            if (root.val <= root.left.val || root.val >= root.right.val) {
                return false;
            }
            // 遍历子树
            if (root.val >= rootVal) return false;
            isValidBST2(root.left, rootVal);
            if (root.val <= rootVal) return false;
            isValidBST2(root.right, rootVal);

            break;
        }
        return true;
    }
}

