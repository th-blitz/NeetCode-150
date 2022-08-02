import heapq

def kthSmallest(matrix, k):
        
        n = len(matrix)
        
        min_heap = []
        
        for r in range(min(k, n)):
            min_heap.append((matrix[r][0], r, 0))
            
        heapq.heapify(min_heap)
        
        while k:
            
            ele, r, c = heapq.heappop(min_heap)
            
            if c < n - 1:
                heapq.heappush(min_heap, (matrix[r][c+1], r, c+1))

            k -= 1
            
        return ele
            

matrix = [[1,5,9],[10,11,13],[12,13,15]]
k = 8

print("result : ", kthSmallest(matrix, k))

