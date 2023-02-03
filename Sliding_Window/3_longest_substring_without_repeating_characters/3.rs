

use std::cmp::max;

impl Solution {
    
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut window: Vec<bool> = vec!(false;96);
        let s: Vec<char> = s.chars().collect();
        let mut max_count: usize = 0;
        let mut count: usize = 0;

        fn index(chr: &char) -> usize {
            return (*chr as u32 - 32) as usize;
        }

        let mut i = 0;
        let mut j = 0;
        while j < s.len() {
            
            if (i == j) || (window[index(&s[j])] == false) {
                window[index(&s[j])] = true;
                count += 1;
                max_count = max(count, max_count);
                j += 1;
            } else {
                window[index(&s[i])] = false;
                count -= 1;
                i += 1;
            }
        }
        return max_count as i32;
    }
}