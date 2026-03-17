package com.example.arithmetic;


/*
226. 翻转二叉树
简单
相关标签
相关企业
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
示例 2：

输入：root = [2,1,3]
输出：[2,3,1]

示例 3：
输入：root = []
输出：[]

 */
public class InvertTreeTest {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        invertTree(root1);
        System.out.println(root1);
    }


    public static TreeNode invertTree(TreeNode root) {
        if (root!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
        // root = []
        return null;
    }
}
