package com.example.arithmetic;

public class ReverseListTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(3, null);
//        head.next.next.next= new ListNode(null);

        //123->321
        ListNode reverseList = reverseList(head);
        System.out.println(reverseList);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while (currentNode != null) {
            nextNode=currentNode.next;// 赋值

            currentNode.next=preNode;
            preNode=currentNode;
            currentNode=nextNode;
        }
        return preNode;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;//nextNode定义值
            currentNode.next = preNode;//指针转向
            //下一个节点
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    protected static class ListNode {
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

//    ListNode nextNode;
//    ListNode currentNode = head;
//    ListNode preNode = null;
//
//        while (currentNode != null) {
//        nextNode = currentNode.next;
//        currentNode.next = preNode;
//        preNode = currentNode;
//        currentNode = nextNode;
//    }
//        return preNode;
}
