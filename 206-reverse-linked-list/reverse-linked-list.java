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
    public ListNode reverseList(ListNode head) {
    ListNode dummy = new ListNode();
    ListNode current = head;
    while (current != null) {
            ListNode nextTemp = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = nextTemp;
        }
        return dummy.next;    
    }
}