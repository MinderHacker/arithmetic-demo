package com.example.arithmetic;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbersTest {
    public static void main(String[] args) {

        ListNode l1Node1 = new ListNode(6, null);
        ListNode l1Node2 = new ListNode(5, null);
        ListNode l1Node3 = new ListNode(4, null);
        l1Node2.next = l1Node1;
        l1Node3.next = l1Node2;

        ListNode l2Node1 = new ListNode(7, null);
        ListNode l2Node2 = new ListNode(1, null);
        ListNode l2Node3 = new ListNode(6, null);
        ListNode l2Node4 = new ListNode(1, null);
        l2Node2.next = l2Node1;
        l2Node3.next = l2Node2;
        l2Node4.next = l2Node3;

        ListNode listNode = addTwoNumbers(l1Node3, l2Node4);
        System.out.println("新链表为：" + listNode);
    }


    // 解法思路
    //通过遍历链表的方式，取每个链表的同位节点进行相加，这里需要注意的是进位问题。如果链表长度不同取 0 进行相加。
    // 每两个节点相加后生成新的节点。如果两个数相加大于十，需要进位

    /*
    复杂度分析
    时间复杂度：O(max(m,n))，其中 m和 n分别为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
    空间复杂度：O(1)。注意返回值不计入空间复杂度。
     */

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建新节点保存结果
        ListNode pre = new ListNode(0);
        // 进位值
        int carry = 0;
        // 用于指向两个数保存的位置
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            // 当前位是否有值，null 取 0
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            // 当前位计算结果
            int sum = x + y + carry;
            // 重置进位值
            carry = sum / 10;
            // 记录当前位结果
            sum = sum % 10;
            // 将当前位的值设置为下一个节点
            cur.next = new ListNode(sum);
            // 将节点往后移
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后两个位数相加存在进位值
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        // pre 和 cur 都是指向同一个地址，但是 cur 在循环过程中指向位置发生了改变。
        // return pre.next; 返回指向地址，LeetCode 会自己解析（我是这么理解的）
        return pre.next;
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
