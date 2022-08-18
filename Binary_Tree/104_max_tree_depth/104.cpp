#include "../tree.cpp"
#include <algorithm>
#include <vector>


int maxDepth(BinaryTree *root) {

    if (root == nullptr) {
        return 0;
    }
    return std::max(
        maxDepth(root -> left),
        maxDepth(root -> right)
    ) + 1; 
}


int main() {
    std::vector<int> array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    BinaryTree* root = build_tree(array);
    print_tree(root);
    std::cout << " " << std::endl;
    int max_depth = maxDepth(root);
    std::cout << " max depth : " << max_depth << std::endl;
}


