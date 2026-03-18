package com.example.arithmetic;

public class ListNode {
    int val;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, com.example.arithmetic.ListNode next) {
        this.val = val;
        this.next = next;
    }
}
