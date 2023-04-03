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
// class Solution {
//     //T: O(M + N), M: O(1)
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//         ListNode prev = new ListNode(-1);
//         prev.next = list1;
//         ListNode dummy = prev;

//         while(list1 != null || list2 != null) {

//             if (list1 == null) {
//                 prev.next = list2;
//                 break;
//             } else if (list2 == null) {
//                 prev.next = list1;
//                 break;
//             } else if (list2.val <= list1.val) {
//                 prev.next = list2;
//                 list2 = list2.next;
//                 prev = prev.next;
//             } else {
//                 prev.next = list1;
//                 list1 = list1.next;
//                 prev = prev.next;
//             }
//         }
//         return dummy.next;
//     }
// }

class Solution {
    // T: O(M + N), S: O(M + N)

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Base cases
        if (list1 == null) return list2;

        if (list2 == null) return list1;

        // recursive relation
        ListNode head;

        if (list1.val <= list2.val) {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }

        return head;
    }
}