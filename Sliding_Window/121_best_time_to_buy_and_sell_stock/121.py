

def maxProfit(prices):        
        
        min_price = prices[0]
        max_profits = 0
        
        for i in range(1, len(prices)):
            
            min_price = min(min_price, prices[i])
            max_profits = max(prices[i] - min_price, max_profits)
            
        return max_profits


if __name__ == "__main__":
    prices = [7,1,5,3,6,4]
    print("result : ", maxProfit(prices))

