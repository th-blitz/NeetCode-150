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


int main() {
    std::vector<int> array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    BinaryTree* p = build_tree(array);
    print_tree(p);
    std::cout << " " << std::endl;
    BinaryTree* q = build_tree(array);
    print_tree(q);
    std::cout << " " << std::endl;
    
    std::cout << " is same : " << isSame(p, q) << std::endl;
}


