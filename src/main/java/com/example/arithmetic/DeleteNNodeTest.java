package com.example.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2026/3/18 14:38
 * 2.	删除链表中倒数第 N 个节点
 *
 *输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 */
public class DeleteNNodeTest {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next=new ListNode(3);
        ln.next.next.next=new ListNode(4);
        ln.next.next.next.next=new ListNode(5);// 1 2 3 4 5=> 1 2 3 5
        int n = 2;
        ListNode listNode = deleteNNode(ln, n);
        System.out.println(listNode);
    }

    // 删除链表中倒数第 N 个节点
    private static ListNode deleteNNode(ListNode ln, int n) {
        if (ln == null || n <= 0) {
            return ln;
        }
        ListNode slow = ln;
        ListNode fast = ln;
        // 快指针先移动 n 步
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // n 超过链表长度，返回原链表
                return ln;
            }
            fast = fast.next;
        }
        // 如果 fast 为 null，说明要删除的是头节点
        if (fast == null) {
            return ln.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return ln;
    }
}
