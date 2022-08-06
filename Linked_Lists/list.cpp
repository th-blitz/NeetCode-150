#include <iostream>
#include <vector>

struct SingleListNode {
    int val;
    SingleListNode *next;
    SingleListNode() : val(0), next(nullptr) {}
    SingleListNode(int x) : val(x), next(nullptr) {}
    SingleListNode(int x, SingleListNode *next) : val(x), next(next) {}
};

SingleListNode *buildTree(std::vector<int> &array) {
    SingleListNode *root;
    if (array.size() != 0) {
        SingleListNode *node;
        node = new SingleListNode(array[0], nullptr);
        root = node;
        for (int i = 1; i < array.size(); i++) {
            node -> next = new SingleListNode(array[i]);
            node = node -> next;
        }
    }
    return root;
}

void stdout_list(SingleListNode *node) {
    std::cout << "{ ";
    while (node != nullptr) {
        std::cout << node -> val << " ";
        node = node -> next;
    }
    std::cout << "} " << std::endl;
}

