

impl Solution {
    pub fn get_sum(a: i32, b: i32) -> i32 {
        let mut a: u32 = a as u32;
        let mut b: u32 = b as u32;
        let mut temp: u32;
        let mask: u32 = 0xffffffff;

        while b != 0 {
            temp = (a ^ b) & mask;
            b = ((a & b) & mask) << 1;
            a = temp;
        }
        let result = if a < 0x7fffffff { a } else { !(a ^ mask) };
        return result as i32;
    }
}