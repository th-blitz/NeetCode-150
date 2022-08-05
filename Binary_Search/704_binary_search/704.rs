


fn search(nums: &Vec<i32>, target: &i32) -> i32 {
        
    fn recur(left: isize, right: isize, nums: &Vec<i32>, target: &i32) -> isize {
        
        if left > right {
            return -1;
        }
        
        let mid: isize = (left + right) / 2;
        
        if nums[mid as usize] == *target {
            return mid;
        }
        
        if nums[mid as usize] > *target {
            return recur(left, mid - 1, nums, target);
        }
        return recur(mid + 1, right, nums, target);
    }
    
    let right: isize = (nums.len() - 1) as isize;
    return recur(0, right, nums, target) as i32;   
}


fn main() {

    let nums: Vec<i32> = vec!(-1, 0, 3, 5, 9, 12);
    let target: i32 = 9;

    let result = search(&nums, &target);

    println!("nums : {:?} target : {} result : {}", nums, target, result);

}