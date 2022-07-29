
use std::collections::HashMap;

fn hashmap_method(nums: Vec<i32>, target: i32) -> Vec<i32> {
    
    let mut hashmap: HashMap<i32, i32> = HashMap::new();
    let mut result: Vec<i32> = Vec::new();
    let mut i:i32 = 0;
    let mut difference:i32;

    result.push(-1);
    result.push(-1);

    for x in nums.iter() {
        difference = target - x;
        if hashmap.contains_key(&difference) {
            result[0 as usize] = *hashmap.get(&difference).unwrap();
            result[1 as usize] = i;
            return result;
        }
        hashmap.insert(*x, i);
        i += 1;
    }
    return result;
}

fn main() {

    let nums: Vec<i32> = vec![2,7,11,15];
    let target:i32 = 9;
    let result: Vec<i32>;

    result = hashmap_method(nums, target);
    println!("result : {:?}", result)

}