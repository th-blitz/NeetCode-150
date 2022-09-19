

impl Solution {
    pub fn reverse_bits(x: u32) -> u32 {
        let mut result: u32 = 0;
        let mut power: u32 = 31;
        let mut x: u32 = x;
        while x != 0 {
            result += (x & 1) << power;
            x = x >> 1;
            power -= 1;
        }
        return result;
    }
}