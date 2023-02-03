

impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        if n == 1 {
            return 1;
        }
        let mut dp: Vec<i32> = vec![0;n as usize];
        dp[0] = 1;
        dp[1] = 2;
        let n: usize = n as usize;
        for i in 2..n {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}