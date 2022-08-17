#include "../tree.cpp"
#include <vector>


BinaryTree *invertTree(BinaryTree *root) {
    if (root == nullptr) {
        return root;
    }
    BinaryTree* inverted_right = invertTree(root -> right);
    BinaryTree* inverted_left = invertTree(root -> left);
    root -> right = inverted_left;
    root -> left = inverted_right;
    return root; 
}


int main() {
    std::vector<int> array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    BinaryTree* root = build_tree(array);
    print_tree(root);
    std::cout << " " << std::endl;
    root = invertTree(root);
    print_tree(root);
}




