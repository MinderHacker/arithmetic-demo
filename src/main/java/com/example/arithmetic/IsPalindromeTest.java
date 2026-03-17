package com.echo.javademo.arithmetic;


import java.util.ArrayList;
import java.util.Stack;

/*
回文链表
简单
1.8K
相关企业
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

示例 1：
输入：head = [1,2,2,1]
输出：true
示例 2：


输入：head = [1,2]
输出：false

 */
public class IsPalindromeTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1, null);

        //1221->1221
        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }


    // ?
    private static ListNode frontPointer;
    public static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    //1221
    //方法3： 遍历链表，把链表数据加入list;双指针单个比较数据
    public static boolean isPalindrome4(ListNode head) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodeList.add(temp.val);
            temp = temp.next;
        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) != nodeList.get(nodeList.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //方法2：  思路：先把数据装进栈里；然后从栈里取出数据和之前的元素比较；如果是回文数据，就返回true
    public static boolean isPalindrome3(ListNode head) {
        ListNode temp = head;
        ListNode temp2 = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (!stack.empty()) {
            if (temp2.val != stack.pop()) {
                return false;
            }
            temp2 = temp2.next;
        }
        return true;
    }

    // 方法1：先反转链表，然后遍历单个比值
    public static boolean isPalindrom2(ListNode head) {
        ListNode q = head;
        ListNode node = head;
        ListNode p = reverseList(node);

        while (q != null && p != null) {
            if (q.val != p.val) return false;
            q = q.next;
            p = p.next;
        }
        return true;
    }

    // 反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode nextNode;
        ListNode currentNode = head;
        ListNode preNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
