package com.echo.javademo.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 20/09/2023 18:47
 */

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 */
public class InorderTraversalTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

//        List<Integer> resultList = new ArrayList<>();
//        List<Integer> integerList = inorderTraversal(root, resultList);
        List<Integer> integerList = inorderTraversal(root);
        System.out.println(integerList);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        return inorder(root,resultList);
        //return resultList;
    }

    public static List<Integer> inorder(TreeNode root, List<Integer> resultList) {
        if (root == null) return resultList;
        inorder(root.left, resultList);
        resultList.add(root.val);
        inorder(root.right, resultList);
        return resultList;
    }

    // 中序 遍历
//    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> resultList) {
//        if (root == null) return resultList;
//        inorderTraversal(root.left, resultList);
//        resultList.add(root.val);
//        inorderTraversal(root.right, resultList);
//        return resultList;
//    }

    // 定义树节点
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int node) {
            this.val = node;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
