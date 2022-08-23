#include "../tree.cpp"
#include <algorithm>
#include <vector>


bool isSame(BinaryTree* p, BinaryTree* q) {
    if (p == nullptr && q == nullptr) {
        return true;
    }
    if ((p == nullptr || q == nullptr) || (p -> val != q -> val)) {
        return false;
    }
    return (isSame(p -> left, q -> left) && isSame(p -> right, q -> right));
}

bool isSubtree(BinaryTree* root, BinaryTree* subRoot) {
    if (root == nullptr) {
        return false;
    }
    bool compareTree = false;
    if (root -> val == subRoot -> val) {
        compareTree = isSame(root, subRoot);
    }
    return (isSubtree(root -> left, subRoot) || isSubtree(root -> right, subRoot) || compareTree);
}


int main() {
    std::vector<int> pArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    std::vector<int> qArray = {5, 6, 7, 8, 9};
    
    BinaryTree* p = build_tree(pArray);
    print_tree(p);
    std::cout << " " << std::endl;

    BinaryTree* q = build_tree(qArray);
    print_tree(q);
    std::cout << " " << std::endl;
    
    std::cout << " is same : " << isSubtree(p, q) << std::endl;
}

