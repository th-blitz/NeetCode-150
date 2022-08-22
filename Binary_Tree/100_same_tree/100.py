import sys
sys.path.append(r'/home/mount/Binary_Tree/')
import tree


def isSameTree(p, q) -> bool:
        
        if p == None and q == None:
            return True
        
        if (p == None or q == None) or (p.val != q.val):
            return False
        
        return isSameTree(p.left, q.left) and isSameTree(p.right, q.right)


p = tree.build_tree([2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
q = tree.build_tree([2, 5, 6, 8, 9, 10, 11, 7, 4, 3])
tree.print_tree(p)
tree.print_tree(q)
print(f'is same : {isSameTree(p, q)}')