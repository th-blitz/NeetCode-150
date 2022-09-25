#include <vector>
using namespace std;



class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        nums[1] = max(nums[0], nums[1]);
        int n = nums.size();
        for (int i = 2; i < n; i++) {
            nums[i] = max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return max(nums[n - 1], nums[n - 2]);
    }
};