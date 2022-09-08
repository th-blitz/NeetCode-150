#include <vector>
#include <algorithm>

using namespace std;

class KthLargest {
    
private:
    
    vector<int> heap;
    int k_vals;
    
public:
    KthLargest(int k, vector<int>& nums) {
        
        k_vals = k;
        heap = nums;
        
        for (int i = 0; i < heap.size(); i++) {
            heap[i] *= -1;
        }
        make_heap(heap.begin(), heap.end());
        while (heap.size() > k) {
            pop_heap(heap.begin(), heap.end()); 
            heap.pop_back();
        }
        
    }
    
    int add(int val) {
        heap.push_back(-1 * val);
        push_heap(heap.begin(), heap.end());
        
        if (heap.size() > k_vals) {
            pop_heap(heap.begin(), heap.end());
            heap.pop_back();
        
        }
        
        return -1 * heap.front();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */