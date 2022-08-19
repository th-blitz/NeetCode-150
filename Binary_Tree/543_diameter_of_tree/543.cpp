#include "../tree.cpp"
#include <algorithm>
#include <vector>



int recur(BinaryTree *root, int &maxDiameter) {
    if (root == nullptr) {
        return 0;
    }
    int left_diameter = recur(root -> left, maxDiameter);
    int right_diameter = recur(root -> right, maxDiameter);
    maxDiameter = std::max(maxDiameter, left_diameter + right_diameter);
    return std::max(left_diameter, right_diameter) + 1;
}


int diameterOfTree(BinaryTree *root) {

    int max_diameter = 0;
    recur(root, max_diameter);
    return max_diameter;

}


int main() {
    std::vector<int> array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    BinaryTree* root = build_tree(array);
    print_tree(root);
    std::cout << " " << std::endl;
    int diameter = diameterOfTree(root);
    std::cout << " diameter : " << diameter << std::endl;
}


