import sys
sys.path.append(r'/home/mount/Binary_Tree/')
import tree


def invertTree(root):
    
    def recur(node):
        
        if node == None:
            return node
        
        node.left, node.right = recur(node.right), recur(node.left)
        
        return node
    
    return recur(root)


root = tree.build_tree([2, 3, 4, 5, 6, 7, 8, 9])
tree.print_tree(root)
root = invertTree(root)
tree.print_tree(root)