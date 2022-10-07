


class Solution {
public:
    bool canJump(vector<int>& nums) {
        int good_position = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] + i >= good_position) {
                good_position = i;
            }
        }
        return good_position == 0;
    }
};