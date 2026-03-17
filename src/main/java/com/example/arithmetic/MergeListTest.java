package com.example.arithmetic;

/**
 * 合并两个升序链表
 */
public class MergeListTest {
    public static void main(String[] args) {
        // l1=[1,2,4];l2=[1,3,4]  => [1,1,2,3,4,4]
        ListNode l1Node1 = new ListNode(1);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(4);
        l1Node1.next = l1Node2;
        l1Node2.next= l1Node3;

        ListNode l2Node1  = new ListNode(1, null);
        ListNode l2Node2 = new ListNode(3, null);
        ListNode l2Node3 = new ListNode(4, null);
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;

        ListNode listNode = mergeListNode(l1Node1, l2Node1);
        System.out.println(listNode);
    }

    // 合并两个链表
    private static ListNode mergeListNode(ListNode list1,ListNode list2){
        // 若其中一个链表为null
        if (list1==null) return list2;
        if (list2==null) return list1;

        if (list1.val<list2.val){
            list1.next=mergeListNode(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeListNode(list1,list2.next);
            return list2;
        }
    }



    // 建立链表节点
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
