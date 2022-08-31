#include "../tree.h"
#include <stdbool.h>
#include <stdio.h>


struct BinaryTree* lowestCommonAncestor(struct BinaryTree* root, struct BinaryTree* p, struct BinaryTree* q) {
    int rootVal = root -> val;
    int pVal = p -> val;
    int qVal = q -> val;

    if (pVal > rootVal && qVal > rootVal) {
        return lowestCommonAncestor(root -> right, p, q);
    } else if (pVal < rootVal && qVal < rootVal) {
        return lowestCommonAncestor(root -> left, p, q);
    }
    return root;
}


int main() {

    int tree1Size = 5;
    int tree2Size = 3;
    int tree1[] = {1, 2, 3, 4, 5};
    int tree2[] = {3, 4, 5};
    int buffer[10] = {0};

    struct BinaryTree* p = build_tree(tree1, tree1Size, buffer);
    struct BinaryTree* q = build_tree(tree2, tree2Size, buffer);
    print_tree(p, 1);
    print_tree(q, 1);
    
    printf("\n lowest common ancestors : %d \n", isSubtree(p, q));

}