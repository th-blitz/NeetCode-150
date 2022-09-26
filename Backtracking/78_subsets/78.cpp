#include <vector>
using namespace std;

class Solution {
public:
    
    vector<int> copy(vector<int> set, int num) {
        vector<int> copy(set.size() + 1, 0);
        for (int i = 0; i < set.size(); i++) {
            copy[i] = set[i];
        }
        copy[set.size()] = num;
        return copy;
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        
        vector<vector<int>> subsets = {{}};
        int size;
        
        for (int i = 0; i < n; i++) {
            size = subsets.size();
            for (int j = 0; j < size; j++) {
                subsets.push_back(copy(subsets[j], nums[i]));
            }
        }
        return subsets;
    }
};