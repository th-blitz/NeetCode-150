import collections


class BinaryTree:
    def __init__(self, val = None, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right


def build_tree(array):
    root = None
    if len(array) > 0:
        array.sort()
        def recur(left, right):
            if left > right:
                return None
            mid = (left + right) // 2
            return BinaryTree(
                val = array[mid], 
                left = recur(left, mid - 1), 
                right = recur(mid + 1, right)
            )
        root = recur(0, len(array) - 1)
    return root


def max_height(root):

    def recur(node, depth):

        if node == None:
            return depth

        return max(
            recur(node.left, depth + 1),
            recur(node.right, depth + 1)
        )

    return recur(root, -1)

## @ https://stackoverflow.com/questions/48850446/how-to-print-a-binary-tree-in-as-a-structure-of-nodes-in-python/58104529#58104529
def print_tree(root):
    res = []
    q = collections.deque()
    max_depth = max_height(root)
    q.append((root, 0))
    while q:
        row = []
        for _ in range(len(q)):
            node, depth = q.popleft()
            if not node:
                if depth <= max_depth:
                    row.append("#")
                continue
            row.append(node.val)
            q.append((node.left, depth + 1))
            q.append((node.right, depth + 1))
        res.append(row)
    rows = len(res)
    base = 2**(rows)
    for r in range(rows):
        for v in res[r]:
            print("." * (base), end = "")
            print(v, end = "")
            print("." * (base - 1), end = "")
        print("|")
        base //= 2



# array = [x for x in range(10)]
# root = build_tree(array)
# print_tree(root)
