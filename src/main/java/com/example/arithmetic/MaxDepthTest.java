package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2023/9/25 20:02
 */
public class MaxDepthTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        int depth = maxDepth(root);
        System.out.println(depth);
    }

    /*
    如果我们知道了左子树和右子树的最大深度 l 和 r，那么该二叉树的最大深度即为max(l,r)+1
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
//        int d1 = maxDepth(root.left);//?
//        int d2 = maxDepth(root.right);// ?
//        int depth = Math.max(d1,d2)+1;
//        return depth;
        // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
