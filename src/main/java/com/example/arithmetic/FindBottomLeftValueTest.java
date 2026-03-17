package com.echo.javademo.arithmetic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的根节点 root，请找出改二叉树的最底层最左边节点的值，假设二叉树中至少有一个节点
 */
public class FindBottomLeftValueTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        int result = findBottomLeftValue(root);
        System.out.println("最底层最左边节点的值是：" + result);
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int potentialResult = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // 如果是每层的最左边节点，则更新 potentialResult
                if (i == 0) {
                    potentialResult = current.val;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return potentialResult;
    }

}

