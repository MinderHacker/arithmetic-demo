package com.example.arithmetic;

/*
148. 排序链表
中等
相关标签
相关企业
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]

示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

示例 3：
输入：head = []
输出：[]
 */
public class SortListTest {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = sortList(n1);
        System.out.println(listNode);
    }


    /*
    分治算法：先分后和
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针
        ListNode fast = head.next, slow = head;
        // 快慢指针找到中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;// 断开链表
        slow.next = null;

        // 分别递归两段链表
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        // 合并
        // 创建一个辅助 ListNode h 作为头部
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = (left != null) ? left : right;
        return res.next;
    }

    //https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
    public static ListNode sortList2(ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null)
            return head;

        //1. 快慢指针寻找中间节点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;// 中间节点
        slow.next = null;//分成两部分。前面一段，后面一段

        // 分别递归两个节点
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);//建立辅助 ListNode h 作为头部
        ListNode res = h;

        //2.合并
        //设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，
        // 指针交替前进，直至添加完两个链表。
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = ((left != null) ? left : right);
        return res.next;
    }
}
