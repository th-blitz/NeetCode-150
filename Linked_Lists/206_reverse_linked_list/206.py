import sys
sys.path.append(r'/home/mount/Linked_Lists/')
from list import Single_Linked_List


def reverseList(head):
        
        if head == None:
            return head
        if head.next == None:
            return head
        
        last_node = reverseList(head.next)
        head.next.next = head
        head.next = None
        return last_node

linked_list = Single_Linked_List([1, 2, 3, 4, 5, 6])
linked_list.print()

root = linked_list.root
root = reverseList(root)
linked_list.print_from("result : ", root)



