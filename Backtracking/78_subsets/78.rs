

impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut result: Vec<Vec<i32>> = vec!(vec!());
        let mut size: usize = 1;
        for num in nums.iter() {
            for i in 0..size {
                let mut new_set: Vec<i32> = result[i].clone();
                new_set.push(num.clone());
                result.push(new_set);
            }
            size = result.len();
        }
        return result;
    }
}