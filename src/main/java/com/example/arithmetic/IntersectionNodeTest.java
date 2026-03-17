package com.echo.javademo.arithmetic;


/*
相交链表
简单
2.3K
相关企业
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：

题目数据 保证 整个链式结构中不存在环。

注意，函数返回结果后，链表必须 保持其原始结构 。

自定义评测：

评测系统 的输入如下（你设计的程序 不适用 此输入）：
 */
public class IntersectionNodeTest {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);

        ListNode headB = new ListNode(0);
        headB.next = new ListNode(3);
        headB.next.next = new ListNode(4);

        headA.next.next = headB.next.next.next = new ListNode(5);
        headA.next.next.next = headB.next.next.next.next = new ListNode(6);
        headA.next.next.next.next = headB.next.next.next.next.next = new ListNode(7);

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println(result);
    }

    /*
     1.有相交节点，则有共有节点
     双指针
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            // 方法1：
//            A = A != null ? A.next : B;
//            B = B != null ? B.next : A;

            // 方法2：由于链表的非共有节点不同，所以需要循环遍历链表，直到他们相交，则有节点
            A = A != null ? A.next : headA;
            B = B != null ? B.next : headB;
        }
        return A;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
