use std::cmp::max;

impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        
        if nums.len() == 1 {return nums[0];}
        
        fn robbing(nums: &Vec<i32>, i: usize, j: usize) -> i32 {
            let mut first: i32 = 0;
            let mut second: i32 = 0;
            let mut temp: i32;
            for num in nums[i..j].iter() {
                temp = first;
                first = max(num + second, first);
                second = temp;
            }
            return first;
        }
        
        return max(robbing(&nums, 1, nums.len()), robbing(&nums, 0, nums.len() - 1));
    }
}