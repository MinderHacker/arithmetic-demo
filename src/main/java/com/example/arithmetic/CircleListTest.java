package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: 链表是否有环
 * @date 2023/9/24 17:19
 */
public class CircleListTest {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(0, null);
        ListNode node4 = new ListNode(-4, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        boolean isCircle = isCircle(node1);
        System.out.println(isCircle);
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    private static boolean isCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
