#include <iostream>
#include <vector>
#include "../list.cpp"



bool Traverse(SingleListNode* slow, SingleListNode* fast) {

    if (slow == nullptr || slow -> next == nullptr) {
        return false;
    }
    if (fast == nullptr || fast -> next == nullptr) {
        return false;
    }
    if (slow == fast) {
        return true;
    }
    return Traverse(slow -> next, fast -> next -> next);

}


bool hasCycle(SingleListNode* head) {

    if (head == nullptr) {
        return false;
    }

    return Traverse(head, head -> next);
}



int main() {

    std::vector<int> array = {3, 2, 0, -4};
    SingleListNode* head = buildTree(array);

    std::cout << "list : ";
    stdout_list(head);

    head -> next -> next -> next = head;

    std::cout << hasCycle(head) << std::endl;

    return 0;
}