



fn recur(n: usize, l: usize, modulo: &i32, vowels: &Vec<Vec<usize>>, cache: &mut Vec<Vec<i32>>) -> i32 {

    if cache[l][n] > 0 {
        return cache[l][n];
    }
    if n == 0 {
        return 1;
    }
    let mut result: i32 = 0;
    for i in 0..vowels[l].len() {
        result += recur(n - 1, vowels[l][i], modulo, vowels, cache);
        result %= modulo;
    }
    cache[l][n] = result;
    return result;
}


fn count_vowel_permutation(n: i32) -> i32 {

    let vowels: Vec<Vec<usize>> = vec!(
        vec!(1), vec!(0, 2), vec!(0, 1, 3, 4), vec!(2, 4), vec!(0)
    );

    let mut cache: Vec<Vec<i32>> = vec![vec![0;n as usize];vowels.len()];

    let mut result: i32 = 0;
    let modulo: i32 = 1000000007;

    for i in 0..vowels.len() {
        result += recur((n - 1) as usize, i, &modulo, &vowels, &mut cache);
        result %= modulo;
    }
    return result;
}



fn main() {

    let n: i32 = 20000;
    let result = count_vowel_permutation(n);
    println!("n : {} | result : {}", n, result);
    
}