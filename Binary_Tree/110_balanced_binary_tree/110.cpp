#include "../tree.cpp"
#include <algorithm>
#include <vector>
#include <cstdlib>


int height(BinaryTree *root) {
    if (root == nullptr) {
        return 0;
    }
    return std::max(
        height(root -> left),
        height(root -> right)
    ) + 1;
}


bool isBalanced(BinaryTree* root) {

    if (root == nullptr) {
        return true;
    }    
    return ((std::abs(height(root -> left) - height(root -> right)) < 2) && (isBalanced(root -> left)) && (isBalanced(root -> right)));
}

int main() {
    std::vector<int> array = {1, 2, 3, 4, 5, 6, 7, 8};
    BinaryTree* root = build_tree(array);
    print_tree(root, 1);

    std::cout << " " << std::endl;
    std::cout << "is balanced : " << isBalanced(root) << std::endl;
    return 0;
}