#include "../tree.h"
#include <stdlib.h>
#include <stdio.h>


int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}

int recur(struct BinaryTree* root, int* maxDiameter) {
    if (root == NULL) {
        return 0;
    }
    int leftHeight = recur(root -> left, maxDiameter);
    int rightHeight = recur(root -> right, maxDiameter);
    *maxDiameter = max(*maxDiameter, leftHeight + rightHeight);
    return max(leftHeight, rightHeight) + 1;
}

int diameterOfTree(struct BinaryTree* root) {

    int * maxDiameter;
    int result = 0;
    maxDiameter = &result;
    recur(root, maxDiameter);
    return result;
}


int main() {
    int array[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arraySize = 10;
    int bufferArray[10] = {0};

    struct BinaryTree* root = build_tree(array, arraySize, bufferArray);
    print_tree(root, 1);
    
    int max_diameter = diameterOfTree(root);
    printf("\n diameter : %d \n", max_diameter);

}