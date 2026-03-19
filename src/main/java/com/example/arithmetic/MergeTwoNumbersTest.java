package com.example.arithmetic;

/**
 * 合并两个链表，按照升序进行排序
 */
public class MergeTwoNumbersTest {
    public static void main(String[] args) {

//        ListNode l1Node1 = new ListNode(4, null);
//        ListNode l1Node2 = new ListNode(5, null);
//        ListNode l1Node3 = new ListNode(6, null);
//        l1Node1.next = l1Node2;
//        l1Node2.next = l1Node3;// 4 5 6
        ListNode l1Node1 = new ListNode(1);
        l1Node1.next = new ListNode(3);
        l1Node1.next.next = new ListNode(5);// 1 3 5

//        ListNode l2Node1 = new ListNode(4, null);
//        ListNode l2Node2 = new ListNode(6, null);
//        ListNode l2Node3 = new ListNode(7, null);
//        ListNode l2Node4 = new ListNode(8, null);
//        l2Node1.next = l2Node2;
//        l2Node2.next = l2Node3;
//        l2Node3.next = l2Node4; // 4 6 7 8
        ListNode l2Node1 = new ListNode(2);
        l2Node1.next=new ListNode(4);
        l2Node1.next.next= new ListNode(6);// 2 4 6

        ListNode listNode = mergeTwoNumbers(l1Node1, l2Node1);
        System.out.println("新链表为：" + listNode);
    }

    //合并两个链表，按照升序进行排序
    private static ListNode mergeTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;// 游标节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;// 游标节点后移
        }
        // 如果某一个链表有剩余，则将剩余的链表拼接到末尾
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}



