#include "../list.h"
#include <stdlib.h>
#include <stdio.h>

// LIST NODE DEFINITION
// struct SingleListNode {
//     int val;
//     struct SingleListNode *next;
// };

struct SingleListNode *reverseList(struct SingleListNode* head) {
    
    if (head == NULL) {
        return NULL;
    } else if (head->next == NULL) {
        return head;
    }

    struct SingleListNode* lastNode = reverseList(head->next);
    head->next->next = head;
    head->next = NULL;
    return lastNode;
}


int main() {

    int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arraySize = 9;

    struct SingleListNode *root = build_list(array, arraySize);

    printf("list : ");
    print_nodes(root);
    root = reverseList(root);
    printf("result : ");
    print_nodes(root);

    return 0;
}