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


bool isSubtree(struct BinaryTree* root, struct BinaryTree* subRoot){
    
    if (root == NULL) {
        return false;
    }
    bool compareTree = false;
    if (root -> val == subRoot -> val) {
        compareTree = isSame(root, subRoot);
    }
    return (isSubtree(root -> left, subRoot) || isSubtree(root -> right, subRoot) || compareTree);

}


int main() {

    int tree1[10] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int tree1Size = 10;

    int tree2[5] = {7, 8, 9, 10, 11};
    int tree2Size = 5;

    int buffer[10] = {0};

    struct BinaryTree* p = build_tree(tree1, tree1Size, buffer);
    struct BinaryTree* q = build_tree(tree2, tree2Size, buffer);
    print_tree(p, 1);
    print_tree(q, 1);
    
    printf("\n max depht : %d \n", isSubtree(p, q));

}