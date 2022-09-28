#include <vector>
using namespace std;

class Solution {
public:
    
    int robbing(vector<int> &nums, int i, int j) {
        int first = 0;
        int second = 0;
        int temp;
        for (int k = i; k < j; k++) {
            temp = first;
            first = max(nums[k] + second, first);
            second = temp;
        }
        return first;
    }
    
    int rob(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        return max(robbing(nums, 1, nums.size()), robbing(nums, 0, nums.size() - 1));
    }
};