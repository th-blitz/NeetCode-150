


fn two_sum(numbers: &Vec<i32>, target: i32) -> Vec<i32> {

    let mut i: usize = 0;
    let mut j = (numbers.len() - 1) as usize;
    let mut summation: i32;

    while i < j {

        summation = numbers[i] + numbers[j];

        if summation == target {
            return vec![(i + 1) as i32, (j + 1) as i32];
        }
        if summation < target {
            i += 1;
        } else {
            j -= 1;
        }
    }

    return vec![-1 as i32, -1 as i32];

}

fn main() {

    let numbers: Vec<i32> = vec![2,7,11,15];
    let target: i32 = 9;

    let result = two_sum(&numbers, target);
    println!("result : {:?}", result)

}