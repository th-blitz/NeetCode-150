#include <stdlib.h>
#include <stdio.h>

struct SingleListNode {
    int val;
    struct SingleListNode *next;
};

struct SingleListNode *build_list(int *array, int arraySize) {
    
    struct SingleListNode *root = NULL;
    if (arraySize != 0) {
        struct SingleListNode *node = NULL;
        node = (struct SingleListNode*)malloc(sizeof(struct SingleListNode));
        node->val = array[0];
        node->next = NULL;
        root = node;
        for (int i = 1; i < arraySize; i++) {
            node->next = (struct SingleListNode*)malloc(sizeof(struct SingleListNode));
            node->next->val = array[i];
            node->next->next = NULL;
            node = node->next;
        }
    }
    return root;
}

void print_nodes(struct SingleListNode *node) {
    printf("{ ");
    while (node != NULL) {
        printf("%d ", node->val);
        node = node->next;
    }
    printf("}\n");
}
