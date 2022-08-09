use std::cmp::max;


pub fn length_of_lis(nums: &Vec<i32>) -> i32 {
    
    fn recur(index: usize, nums: &Vec<i32>, memory: &mut Vec<usize>) -> usize {
        if memory[index] > 0 {
            return memory[index];
        }
        let mut max_depth: usize = 0;
        for i in (0..index).rev() {
            if nums[i] < nums[index] {
                max_depth = max(max_depth, recur(i, nums, memory));
            }
        } 
        
        memory[index] = max_depth + 1;
        return memory[index];
    }
    
    let mut memory: Vec<usize> = vec!(0;nums.len());
    memory[0] = 1;
    let mut max_depth: usize = 0;
    for i in (0..nums.len()).rev() {
        max_depth = max(max_depth, recur(i, &nums, &mut memory));
    }
    return max_depth as i32;
    
}

fn main() {
    let nums: Vec<i32> = vec!(10,9,2,5,3,7,101,18);
    let result = length_of_lis(&nums);
    println!("nums : {:?} | result : {}", nums, result);
}