
class DisjointSet:
    
    def __init__(self, size):
        self.root = [i for i in range(size)]
        
    def find(self, x):
        if x == self.root[x]:
            return x
        self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def unite(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        
        if rootX != rootY:
            self.root[rootY] = rootX

    def connected(self, x, y):
        return self.find(x) == self.find(y)

class Solution:
    def minCostConnectPoints(self, points) -> int:
        
        num_pts = len(points)
        edges = []
        
        def Distance(A, B):
            return abs(A[0] - B[0]) + abs(A[1] - B[1])
        
        for i in range(num_pts):
            for j in range(i+1, num_pts):
                edges.append([Distance(points[i], points[j]), i, j])
            
        edges.sort(key = lambda x : x[0])
        disjoint_set = DisjointSet(num_pts)
        
        count = 0
        i = 0
        sum_ = 0
        while count < num_pts-1:
            edg = edges[i]
            if disjoint_set.connected(edg[1], edg[2]) == False:
                disjoint_set.unite(edg[1], edg[2])
                count += 1
                sum_ += edg[0]
            i += 1
            
        return sum_
        
        