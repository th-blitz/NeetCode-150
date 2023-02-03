import heapq

class Solution:
    def canAttendMeetings(self, intervals) -> bool:
        
        heapq.heapify(intervals)
        
        prev_end = -1
        for _ in range(len(intervals)):
            start, end = heapq.heappop(intervals)
            if start >= prev_end:
                prev_end = end
            else:
                return False
        
        return True