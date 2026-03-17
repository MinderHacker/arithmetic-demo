package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 20/09/2023 22:36
 */

/**
 * 对称二叉树
 * 简单
 * 2.5K
 * 相关企业
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetricTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }

    private static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode nodeA, TreeNode nodeB) {
        // 归：传入A节点和传入B节点判断
        if (nodeA == null && nodeB == null) return true;
        if (nodeA == null || nodeB == null) return false;
        if (nodeA.val != nodeB.val) return false;
        return check(nodeA.left, nodeB.right) && check(nodeA.right, nodeB.left);
    }

    class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        return check(root,root);
//    }

//    public boolean check(TreeNode nodeA,TreeNode nodeB){
//        // 归：传入A节点和传入B节点判断
//        if(nodeA == null && nodeB == null) return true;
//        if(nodeA == null || nodeB == null) return false;
//        if(nodeA.val != nodeB.val) return false;
//        // 递：当前A节点的左 == 当前B节点的右 && 当前A节点的右 == 当前B节点的左
//        return check(nodeA.left,nodeB.right) && check(nodeA.right,nodeB.left);
//    }

        private class TreeNode<T> {
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


}
