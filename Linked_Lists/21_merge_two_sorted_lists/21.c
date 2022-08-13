#include "../list.h"
#include <stdlib.h>
#include <stdio.h>




struct SingleListNode *mergeTwoLists(struct SingleListNode* list1, struct SingleListNode* list2) {

    if (list1 == NULL && list2 == NULL) {
        return NULL;
    } else if (list1 != NULL && list2 == NULL) {
        return list1;
    } else if (list2 != NULL && list1 == NULL) {
        return list2;
    }

    struct SingleListNode* temp_node = NULL;
    struct SingleListNode* i = list1;
    struct SingleListNode* j = list2;

    if (i -> val < j -> val) {
        temp_node = i;
        i = i -> next;
    } else {
        temp_node = j;
        j = j -> next;
    }

    struct SingleListNode* root = temp_node;
    while((i != NULL) || (j != NULL)) {
        if ((j == NULL) || ((i != NULL) && (i -> val < j -> val))) {
            temp_node -> next = i;
            i = i -> next;
        } else {
            temp_node -> next = j;
            j = j -> next;
        }
        temp_node = temp_node -> next;
    }
    return root;
}

int main() {

    int list1Array[] = {1, 2, 5, 8};
    int list1ArraySize = 4;

    int list2Array[] = {1, 3, 4, 6};
    int list2ArraySize = 4;

    struct SingleListNode* list1 = build_list(list1Array, list1ArraySize);
    struct SingleListNode* list2 = build_list(list2Array, list2ArraySize);

    printf("list 1 : ");
    print_nodes(list1);
    printf("list 2 : ");
    print_nodes(list2);
    printf("merged list : ");
    print_nodes(mergeTwoLists(list1, list2));

    return 0;
}
