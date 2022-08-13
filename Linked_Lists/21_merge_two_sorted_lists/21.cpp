#include <iostream>
#include <vector>
#include "../list.cpp"



SingleListNode *mergeTwoLists(SingleListNode* list1, SingleListNode* list2) {

    if (list1 == nullptr && list2 == nullptr) {
        return nullptr;
    } else if (list1 != nullptr && list2 == nullptr) {
        return list1;
    } else if (list2 != nullptr && list1 == nullptr) {
        return list2;
    }

    SingleListNode * temp_node = nullptr;
    SingleListNode * i = list1;
    SingleListNode * j = list2;

    if (list1 -> val < list2 -> val) {
        temp_node = i;
        i = i -> next;
    } else {
        temp_node = j;
        j = j -> next;
    }

    SingleListNode * root = temp_node;
    while ((i != nullptr) || (j != nullptr)) {
        if ((j == nullptr) || ((i != nullptr) && (i -> val < j -> val))) {
            temp_node -> next = i;
            i = i -> next;
        } else {
            temp_node -> next = j;
            j = j -> next;
        }
        temp_node = temp_node -> next;
    }

    return root;

}


int main() {

    std::vector<int> list1_array = {1, 2, 5, 8};
    std::vector<int> list2_array = {1, 3, 4, 6};

    SingleListNode *list1 = buildTree(list1_array);
    SingleListNode *list2 = buildTree(list2_array);

    std::cout << "list1 : ";
    stdout_list(list1);
    std::cout << "list2 : ";
    stdout_list(list2);
    std::cout << std::endl;

    std::cout << "merged list : ";
    stdout_list(mergeTwoLists(list1, list2));
    std::cout << std::endl;

    return 0;
}