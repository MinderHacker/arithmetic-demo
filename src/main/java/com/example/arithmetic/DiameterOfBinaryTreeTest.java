package com.example.arithmetic;

/*
二叉树的直径
简单
1.4K
相关企业
给你一棵二叉树的根节点，返回该树的 直径 。
二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。
示例 1：
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
示例 2：
 */
public class DiameterOfBinaryTreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        int diameter = diameterOfBinaryTree(root);
        System.out.println(diameter);// 4

    }

    // 深度优先搜索
    // l+r-1
    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    private static int dfs(TreeNode node) {
//        if (root.left == null && root.right == null) return 0;
//        int leftSize = root.left == null ? 0 : dfs(root.left);
//        int rihtSize =root.right==null?0:dfs(root.right);
//        max= Math.max(leftSize+rihtSize+1,max);

        if (node == null) return 0;
        int left = dfs(node.left);// 左子树的路径
        int right = dfs(node.right);
        max = Math.max(left + right + 1, max);// 更新节点之和的最大值
        return Math.max(left, right) + 1;//节点的子树深度
    }


    public static class TreeNode<T> {
        T data;
        TreeNode left;
        TreeNode right;

        public TreeNode(T data) {
            this.data = data;
        }

        public TreeNode(T data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
