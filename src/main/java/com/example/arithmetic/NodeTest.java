package com.echo.javademo.arithmetic;


/**
 * 题目描述
 * 翻转一个链表。
 * 输入输出样例
 * 输入一个链表，输出该链表翻转后的结果。
 * Input: 1->2->3->4->5->nullptr
 * Output: 5->4->3->2->1->nullptr
 */
public class NodeTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        // 展示连接后的链表
        showLink(node1);

        // 反转链表后展示
        showLink(reverseNode(node1));
    }

    /**
     * 反转链表节点
     *
     * @param node 传入的节点
     * @return
     */
    private static Node reverseNode(Node node) {
        Node preNode = null;
        Node currentNode = node;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }


    /**
     * 展示连接后的链表
     *
     * @param node 传入节点
     */
    private static void showLink(Node node) {
        while (node.next != null) {
            System.out.printf("%d--->", node.data);
            node = node.next;
        }
        System.out.printf("%s%n", "null");
    }

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
