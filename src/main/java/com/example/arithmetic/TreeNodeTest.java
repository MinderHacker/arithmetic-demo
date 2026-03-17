package com.echo.javademo.arithmetic;


/**
 * 二叉树遍历
 */
public class TreeNodeTest {
    public static void main(String[] args) {

        // 构建二叉树
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(3);
        root.left.left= new TreeNode(2);
        root.left.right= new TreeNode(4);

        root.right= new TreeNode(7);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(8);


        // 先根遍历
        preOrder(root);
        System.out.println("------------");

        // 后根遍历
        postOrder(root);
        System.out.println("------------");

        // 中根遍历
        inOrder(root);

    }

    private static void  inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);

    }
    /**
     * 后根遍历
     * @param root
     */
    private static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 先根遍历
     * @param root
     */
    private static void preOrder(TreeNode root) {
        if (root ==null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void display(){
        System.out.println(val);
    }

}
