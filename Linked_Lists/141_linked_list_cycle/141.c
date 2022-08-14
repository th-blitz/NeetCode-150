#include "../list.h"
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>



bool Traverse(struct SingleListNode* slow, struct SingleListNode* fast) {

    if (slow == NULL || slow -> next == NULL) {
        return false;
    }

    if (fast == NULL || fast -> next == NULL) {
        return false;
    }

    if (slow == fast) {
        return true;
    }
    return Traverse(slow -> next, fast -> next -> next);
}


bool hasCycle(struct SingleListNode* head) {
    if (head == NULL) {
        return false;
    }
    return Traverse(head, head -> next);
}


int main() {

    int array[] = {3, 2, 0, -4};
    int arraySize = 4;
    struct SingleListNode* head = build_list(array, arraySize);
    printf("list : ");
    print_nodes(head);

    head -> next -> next -> next = head;

    printf("has cycle : %d\n", hasCycle(head));
    return 0;
}