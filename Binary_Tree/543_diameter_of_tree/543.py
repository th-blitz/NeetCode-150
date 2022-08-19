import sys
sys.path.append(r'/home/mount/Binary_Tree/')
import tree


def diameterOfTree(root): 
    
    def recur(root):
        if root == None:
            return 0
        nonlocal max_diameter
        left_diameter = recur(root.left)
        right_diameter = recur(root.right)
        max_diameter = max(max_diameter, left_diameter + right_diameter)
        return max(left_diameter, right_diameter) + 1
        
    max_diameter = 0
    recur(root)
    return max_diameter




root = tree.build_tree([2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
tree.print_tree(root)

diameter = diameterOfTree(root)
print(f'diameter : {diameter}')