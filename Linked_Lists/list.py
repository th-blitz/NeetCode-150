

class Single_List_Node:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

def build_list(array):
    root = None
    if len(array) != 0:
        root = Single_List_Node(array[0])
        node = root
        for val in array[1:]:
            node.next = Single_List_Node(val)
            node = node.next
    return root

def print_list(message, node):
    array = []
    while node != None:
        array.append(node.val)
        node = node.next
    print(message, array)
    return

class Single_Linked_List:
    def __init__(self, array):
        self.__list_len = len(array)
        self.__root = self.build_list(array)
        self.root = self.build_list(array)

    def build_list(self, array):
        root = None
        if len(array) != 0:
            root = Single_List_Node(array[0])
            node = root
            for val in array[1:]:
                node.next = Single_List_Node(val)
                node = node.next
        return root

    def len(self):
        return self.__list_len

    @staticmethod
    def print_from(message, node):
        array = []
        while node != None:
            array.append(node.val)
            node = node.next
        print(message, array)
        return

    def print(self):
        self.__temp_array = []
        def recur(node):
            if node: 
                self.__temp_array.append(node.val)
                recur(node.next)
            return
        recur(self.__root)
        print(f"list : {self.__temp_array}")
        self.__temp_array.clear()
        return 