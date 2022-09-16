

impl Solution {
    pub fn hammingWeight (n: u32) -> i32 {
        let mut sum: i32 = 0;
        let mut n = n;
        while n != 0 {
            sum += 1;
            n &= (n - 1);
        }
        return sum;
    }
}