#include "../tree.h"
#include <stdbool.h>
#include <stdio.h>


bool isSame(struct BinaryTree* p, struct BinaryTree* q) {
    if (p == NULL && q == NULL) {
        return true;
    }
    if ((p == NULL || q == NULL) || (p -> val != q -> val)) {
        return false;
    }
    return (isSame(p -> left, q -> left) && isSame(p -> right, q -> right));
}


int main() {
    int array[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arraySize = 10;
    int bufferArray[10] = {0};

    struct BinaryTree* p = build_tree(array, arraySize, bufferArray);
    struct BinaryTree* q = build_tree(array, arraySize, bufferArray);
    print_tree(p, 1);
    print_tree(q, 1);
    
    printf("\n is same : %d \n", isSame(p, q));


}