package com.example.arithmetic;


/*
83. 删除排序链表中的重复元素
简单
相关标签
相关企业
给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回已排序的链表 。

示例 1：
输入：head = [1,1,2]
输出：[1,2]

示例 2：
输入：head = [1,1,2,3,3]
输出：[1,2,3]
 */
public class DeleteDuplicatesTest {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 11233->123
        ListNode listNode = deleteDuplicates(node1);
        System.out.println(listNode);
    }


    /*
    由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
    具体地，我们从指针 cur\textit{cur}cur 指向链表的头节点，随后开始对链表进行遍历。
    如果当前 cur\textit{cur}cur 与 cur.next\textit{cur.next}cur.next 对应的元素相同，那么我们就将 cur.next\textit{cur.next}cur.next 从链表中移除；否则说明链表中已经不存在其它与 cur\textit{cur}cur 对应的元素相同的节点，因此可以将 cur\textit{cur}cur 指向 cur.next\textit{cur.next}cur.next。
    当遍历完整个链表之后，我们返回链表的头节点即可。

    时间复杂度：n

     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
