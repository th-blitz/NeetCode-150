

impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        fn get_next(num: i32) -> i32 {
            let mut next_num: i32 = 0;
            let mut num = num;
            while num != 0 {
                next_num += (num % 10).pow(2);
                num = (num / 10);
            }
            return next_num;
        }
        
        let mut slow: i32 = n;
        let mut fast: i32 = get_next(slow);
        while fast != 1 && slow != fast {
            slow = get_next(slow);
            fast = get_next(get_next(fast));
        }
        return fast == 1;
    }
}