import sys
sys.path.append(r'/home/mount/Linked_Lists/')
import list




def hasCycle(head):
    
    if head is None:
        return False
    
    def Traverse(slow, fast):

        if slow == None or slow.next == None:
            return False
        if fast == None or fast.next == None:
            return False
        
        if slow == fast:
            return True
        return Traverse(slow.next, fast.next.next)
    return Traverse(head, head.next)


head = list.build_list([3, 2, 0, -4])
list.print_list('list : ', head)

head.next.next.next = head

print(f'has cycle : {hasCycle(head)}')