/**
 * Brute Force Approach
 * T: O(N ^ 2)
 * S: O(1)
 *
 * One Pass
 * T: O(N)
 * S: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxValue = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            if ((price - minPrice) > maxValue) {
                maxValue = price - minPrice;
            }
        }

        return maxValue;
    }
}