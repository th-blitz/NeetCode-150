#include <stdio.h>


int min(int a, int b) {
    if (a > b) {
        return b;
    }
    return a;
}

int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}
    

int maxProfit(int* prices, int pricesSize) {
    int min_price = prices[0];
    int max_profits = 0;

    for (int i = 0; i < pricesSize; i++) {
        min_price = min(min_price, prices[i]);
        max_profits = max(prices[i] - min_price, max_profits);
    }
    return max_profits;
}

int main() {

    int pricesSize = 6;
    int prices[] = {7,1,5,3,6,4};

    printf("results : %d \n", maxProfit(prices, pricesSize));

    return 0;
}