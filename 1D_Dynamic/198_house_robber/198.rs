use std::cmp::max;

impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        if nums.len() == 1 {
            return nums[0];
        }
        let mut nums = nums;
        nums[1] = max(nums[0], nums[1]);
        for i in 2..nums.len() {
            nums[i] = max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return max(nums[nums.len() - 1], nums[nums.len() - 2]);
    }
}