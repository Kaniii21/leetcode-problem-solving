/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (l1 != null) {
            value += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            value += l2.val;
            l2 = l2.next;
        }

        ListNode result = new ListNode(value % 10);
        result.next = addTwoNumbers(l1, l2, value / 10);
        return result;    
    }
}