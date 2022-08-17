#include <vector>
#include <bits/stdc++.h>

struct BinaryTree {
    int val;
    BinaryTree* left;
    BinaryTree* right;
    BinaryTree(): val(0), left(nullptr), right(nullptr) {}
    BinaryTree(int x) : val(x), left(nullptr), right(nullptr) {}
    BinaryTree(int x, BinaryTree* left, BinaryTree* right) : val(x), left(left), right(right) {}
};

BinaryTree* build_tree_recur(int left, int right, std::vector<int> &array) {
    if (left > right) {
        return nullptr;
    }
    int mid = (left + right) / 2;
    return new BinaryTree(
        array[mid],
        build_tree_recur(left, mid - 1, array),
        build_tree_recur(mid + 1, right, array)
    );
}

BinaryTree* build_tree(std::vector<int> &array) {
    BinaryTree* root;
    if (array.size() > 0) {
        std::sort(array.begin(), array.end());
        root = build_tree_recur(0, array.size() - 1, array);
    }
    return root;
}

// @ https://stackoverflow.com/questions/13484943/print-a-binary-tree-in-a-pretty-way
void print_tree(BinaryTree* p, int indent = 1)
{
    if(p != NULL) {
        if(p->right) {
            print_tree(p->right, indent+4);
        }
        if (indent) {
            std::cout << std::setw(indent) << ' ';
        }
        if (p->right) std::cout<<" /\n" << std::setw(indent) << ' ';
        std::cout<< p->val << "\n ";
        if(p->left) {
            std::cout << std::setw(indent) << ' ' <<" \\\n";
            print_tree(p->left, indent+4);
        }
    }
}

// int main() {

//     std::vector<int> array = {4, 1, 5, 6, 2, 6,2, 52,5 ,6 ,15 ,6 ,163 , 3};
//     BinaryTree* root = build_tree(array);
//     postorder(root);
//     return 0;
// }
