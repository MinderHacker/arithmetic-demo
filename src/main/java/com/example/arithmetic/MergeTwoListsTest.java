package com.example.arithmetic;


/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoListsTest {
    public static void main(String[] args) {

        ListNode head;//链表的头

        ListNode l1Node1 = new ListNode(1, null);
        ListNode l1Node2 = new ListNode(2, null);
        ListNode l1Node3 = new ListNode(4, null);
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;

        ListNode l2Node1 = new ListNode(1, null);
        ListNode l2Node2 = new ListNode(3, null);
        ListNode l2Node3 = new ListNode(4, null);
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;

        ListNode listNode = mergeTwoLists(l1Node1, l2Node2);
        System.out.println("新链表为：" + listNode);

    }

    // 递归
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1== null){
            return list2;
        }
        if (list2== null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
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
