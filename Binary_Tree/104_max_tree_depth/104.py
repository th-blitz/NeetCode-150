import sys
sys.path.append(r'/home/mount/Binary_Tree/')
import tree


def maxDepth(root):
    
    def recur(node):
        
        if node == None:
            return 0
        
        return max(
            recur(node.left),
            recur(node.right)
        ) + 1
    
    return recur(root)


root = tree.build_tree([2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
tree.print_tree(root)
depth = maxDepth(root)
print(f'max depth : {depth}')