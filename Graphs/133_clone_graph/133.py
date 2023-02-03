

class CloneNode:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node):
        
        visited = {}
        
        def clone_nodes(node):
        
            if not node:
                return node
            
            if node in visited:
                return visited[node]
            
            clone_node = CloneNode(node.val, [])
            visited[node] = clone_node
            
            if node.neighbors:
                clone_node.neighbors = [clone_nodes(n) for n in node.neighbors]
                
            return clone_node
        
        return clone_nodes(node)