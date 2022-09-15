
impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        let mut a: i32 = 0;
        for b in nums.iter() {
            a ^= b;
        }
        return a;
    }
}