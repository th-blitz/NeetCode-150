fn max_sub_array(nums: Vec<i32>) -> i32 {
    let mut current_sum: i32 = nums[0];
    let mut max_sum: i32 = nums[0];
    for x in nums[1..].iter() {
        if current_sum < 0 {
            current_sum = *x;
        } else {
            current_sum += *x;
        }
        if current_sum > max_sum {
            max_sum = current_sum;
        }
    }
    return max_sum;
}
