import sys
sys.path.append(r'/home/mount/Binary_Tree/')
import tree



def isBalanced(root) -> bool:
        
        def height(root):
            if root == None:
                return -1
            return max(
                height(root.left),
                height(root.right)
            ) + 1
        
        def balanced(root):
            if root == None:
                return True
            
            return abs(height(root.left) - height(root.right)) < 2 and balanced(root.left) and balanced(root.right)
        
        return balanced(root)


root = tree.build_tree([1, 2, 3, 4, 5, 6, 7, 8])
tree.print_tree(root)

print(f"is balanced : {isBalanced(root)}")