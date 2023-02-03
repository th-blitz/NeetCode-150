

impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        let mut result: i32 = nums.len() as i32;
        let mut i: i32 = 0;
        for num in nums.iter() {
            result ^= (i ^ num);
            i += 1;
        }
        return result;
    }
}