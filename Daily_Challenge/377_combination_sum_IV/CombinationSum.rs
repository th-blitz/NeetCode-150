
use std::collections::HashMap;


fn combination_sum4(nums: &Vec<i32>, target: i32) -> i32 {
        
    fn recur(target: i32, nums: &Vec<i32>, memoize: &mut HashMap<i32, i32>) -> i32 {
        if memoize.contains_key(&target) {
            return *memoize.get(&target).unwrap();
        }
        if target == 0 {
            return 1 as i32;
        }
        if target < 0 {
            return 0 as i32;
        }
        let mut result: i32 = 0;
        for x in nums {
            result += recur(target - x, nums, memoize);
        }
        memoize.insert(target, result);
        return result;
    }
    
    let mut memoize: HashMap<i32, i32> = HashMap::new();
    return recur(target, &nums, &mut memoize);
    
}

fn main() {
    let nums: Vec<i32> = vec!(1,2,3,8,7,5,9);
    let target: i32 = 10;

    let result: i32 = combination_sum4(&nums, target);

    println!("nums : {:?} & target : {} | result : {}", nums, target, result);
}