#include "iostream";
#include "vector";

int maxProfits(std::vector<int> &prices) {

    int min_price = prices[0];
    int max_profits = 0;

    for (int i = 0; i < prices.size(); i++) {
        min_price = std::min(prices[i], min_price);
        max_profits = std::max(prices[i] - min_price, max_profits);
    }
    return max_profits;
}

int main() {

    std::vector<int> prices = {7,1,5,3,6,4};
    std::cout << "result : " << maxProfits(prices) << std::endl; 

    return 0;
}

