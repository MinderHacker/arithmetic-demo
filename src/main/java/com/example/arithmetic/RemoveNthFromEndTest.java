package com.echo.javademo.arithmetic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 删除链表的倒数第 N 个结点
 * 提示
 * 中等
 * 2.7K
 * 相关企业
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 */
public class RemoveNthFromEndTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5, null);

        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }

    // 方法三：双指针
    /*
    思路与算法
        我们也可以在不预处理出链表的长度，以及使用常数空间的前提下解决本题。
        由于我们需要找到倒数第 n 个节点，因此我们可以使用两个指针 first 和 second同时对链表进行遍历，并且 first比 second超前 n个节点。当 first
        遍历到链表的末尾时，second就恰好处于倒数第 nnn 个节点。
        具体地，初始时 first和 second均指向头节点。
        我们首先使用 first对链表进行遍历，遍历的次数为 n。此时，
        first和 second之间间隔了 n−1个节点，即 first比 second超前了 n个节点。
        在这之后，我们同时使用 first和 second对链表进行遍历。
        当 first遍历到链表的末尾（即 first为空指针）时,second 恰好指向倒数第 n个节点。

     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);//创建亚节点
        ListNode first = head;
        ListNode second = dummy;
        // first比second快n步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // 方法二：栈
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 方法一：计算链表长度
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);//创建亚节点
        // 统计链表元素个数
        int index = 0;
        while (head != null) {
            index++;
            head = head.next;
        }

        ListNode cur = dummy;
        for (int i = 1; i < index - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private static class ListNode {
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
