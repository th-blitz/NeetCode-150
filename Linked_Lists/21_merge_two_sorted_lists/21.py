import sys
sys.path.append(r'/home/mount/Linked_Lists/')
import list



def mergeTwoLists(list1, list2):

    if list1 == None and list2 == None:
        return None
    elif list1 != None and list2 == None:
        return list1
    elif list2 != None and list1 == None:
        return list2

    i = list1
    j = list2
    
    res = None
    if i.val < j.val:
        res = i
        i = i.next
    else:
        res = j
        j = j.next
    
    initial = res
    while i != None or j != None:
        if j == None or (i != None and i.val < j.val):
            res.next = i
            i = i.next
        else:
            res.next = j
            j = j.next

        res = res.next

    return initial


list1 = list.build_list([1,2,4])
list2 = list.build_list([1,3,4])
list.print_list('list1 : ', list1)
list.print_list('list2 : ', list2)

merged_list = mergeTwoLists(list1, list2)
list.print_list('merged list : ', merged_list)

