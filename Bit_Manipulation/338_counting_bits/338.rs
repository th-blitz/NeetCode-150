

impl Solution {
    pub fn count_bits(n: i32) -> Vec<i32> {
        let mut result: Vec<i32> = vec![0;n as usize + 1];
        for i in 1..(n as usize + 1) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}