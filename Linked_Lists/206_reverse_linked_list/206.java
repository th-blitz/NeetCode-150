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
/**
 * T: O(N)
 * S: O(1)
 **/
// class Solution {
//     public ListNode reverseList(ListNode head) {

//         if (head == null) return head;

//         ListNode prev = null;

//         while (head != null) {
//             ListNode next = head.next;
//             head.next = prev;

//             prev = head;
//             head = next;
//         }

//         return prev;
//     }
// }

/**
 * T: O(N)
 * S: O(N)
 **/
class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode lastItem = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return lastItem;
    }
}