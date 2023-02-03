import sys
sys.path.append(r'/home/mount/Binary_Tree/')
import tree


def isSubtree(root , subRoot) -> bool:
        
    def compareTree(p, q):
        if p == None and q == None:
            return True
        
        if (p == None or q == None) or (p.val != q.val):
            return False
        return compareTree(p.left, q.left) and compareTree(p.right, q.right)
    
    
    def findSubNode(root):
        
        if root == None:
            return False
        
        compare_nodes = False
        if root.val == subRoot.val:
            compare_nodes = compareTree(root, subRoot)
        
        return findSubNode(root.left) or findSubNode(root.right) or compare_nodes
        
    return findSubNode(root)


p = tree.build_tree([2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
q = tree.build_tree([7, 9, 8, 10, 11])
tree.print_tree(p)
tree.print_tree(q)
print(f'is same : {isSubtree(p, q)}')