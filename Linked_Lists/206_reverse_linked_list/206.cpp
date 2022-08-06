#include <iostream>
#include <vector>
#include "../list.cpp"

// LIST NODE DEFINITION
// struct SingleListNode {
//     int val;
//     SingleListNode *next;
//     SingleListNode() : val(0), next(nullptr) {}
//     SingleListNode(int x) : val(x), next(nullptr) {}
//     SingleListNode(int x, SingleListNode *next) : val(x), next(next) {}
// };

SingleListNode *reverseList(SingleListNode *head) {
    
    if (head == nullptr) {
        return nullptr;
    } else if (head -> next == nullptr) {
        return head;
    }

    SingleListNode *lastNode = reverseList(head -> next);
    head -> next -> next = head;
    head -> next = nullptr;
    return lastNode;
}


int main() {

    std::vector<int> array = {1, 2, 3, 4, 5, 6};

    SingleListNode *root = buildTree(array);

    std::cout << "list : ";
    stdout_list(root);

    root = reverseList(root);
    std::cout << "result : ";
    stdout_list(root);

    return 0;
}
