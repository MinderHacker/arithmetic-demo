package com.example.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

102. 二叉树的层序遍历
中等
相关标签
相关企业
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。


示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]
 */
public class LevelOrderTest {
    public static void main(String[] args) {
        // [3]
//        TreeNode root = new TreeNode(3);

        // []
//        TreeNode root = new TreeNode();

        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        // root = []
        if (root.val == 0) return res;
        //root = [1]
        if (root.left == null && root.right == null) {
            numsList.add(root.val);
            res.add(numsList);
            return res;
        }

        int val = root.val;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        res.add(Collections.singletonList(val));
        while (leftNode != null || rightNode != null) {
            if (leftNode != null) numsList.add(leftNode.val);
            if (rightNode != null) numsList.add(rightNode.val);
            res.add(numsList);

            if (leftNode != null) leftNode= leftNode.left;
            if (leftNode != null) leftNode = leftNode.right;
            if (rightNode != null) rightNode = rightNode.right;

        }
        return res;
    }
}
