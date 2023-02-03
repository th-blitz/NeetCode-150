

impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let mut good_position: usize = nums.len() - 1;
        for i in (0..nums.len()).rev() {
            if i + nums[i] as usize >= good_position {
                good_position = i;
            }
        }
        return good_position == 0;
    }
}