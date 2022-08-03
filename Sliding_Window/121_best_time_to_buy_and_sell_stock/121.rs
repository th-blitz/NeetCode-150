

fn max_profit(prices: Vec<i32>) -> i32 {
    let mut min_price: i32 = prices[0];
    let mut max_profits: i32 = 0;

    for i in 1..prices.len() {
        min_price = std::cmp::min(prices[i], min_price);
        max_profits = std::cmp::max(prices[i] - min_price, max_profits);
    }

    return max_profits;
}

fn main() {
    
    let prices: Vec<i32> = vec![7,1,5,3,6,4];

    println!("result : {}", max_profit(prices));

}