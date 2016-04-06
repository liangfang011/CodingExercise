package edu.nyu.liangfang.leetcode;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

public class swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        while (curr != null && curr.next != null) {
            ListNode second = curr.next;
            curr.next = second.next;
            second.next = curr;
            pre.next = second;
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
