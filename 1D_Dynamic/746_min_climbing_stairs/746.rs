

use std::cmp::min;

impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        let cost_len: usize = cost.len();
        let mut cost = cost;
        for i in 2..cost_len {
            cost[i] += min(cost[i - 1], cost[i - 2]);
        }
        return min(cost[cost_len - 1], cost[cost_len - 2]);
    }
}