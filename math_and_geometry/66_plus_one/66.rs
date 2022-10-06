

impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut digits = digits;
        let n: usize = digits.len();

        for i in (0..n).rev() {
            if digits[i] == 9 {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        let mut result: Vec<i32> = vec!(1;n + 1);
        for i in 0..n {
            result[i + 1] = digits[i];
        }
        return result;
    }
}