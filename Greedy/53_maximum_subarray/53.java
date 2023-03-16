// Questions During Interview
// 1. If all values are negative no point in including any values.
/**
 * Brute force we can calculate the sum of all possible subarrays
 * T: O(N ^ 2)
 * S: O(1)
 */
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSubarray = Integer.MIN_VALUE;
//         for (int i = 0; i < nums.length; i++) {
//             int currentSubarray = 0;
//             for (int j = i; j < nums.length; j++) {
//                 currentSubarray += nums[j];
//                 maxSubarray = Math.max(maxSubarray, currentSubarray);
//             }
//         }

//         return maxSubarray;
//     }
// }

/**
 * DP Solution (Based on Kadane's Algorithm. Which gives max subarry sum)
 * T: O(N)
 * S: O(1)
 */
// class Solution {
//     public int maxSubArray(int[] nums) {

//         int curSum = 0;
//         int maxSum = Integer.MIN_VALUE;

//         for (int i = 0; i < nums.length; i++) {

//             curSum = Math.max(curSum, 0) + nums[i];
//             maxSum = Math.max(maxSum, curSum);
//         }

//         return maxSum;
//     }
// }

/**
 * Divide and take sum
 * T: O(N * log N) -> log N recursive calls, and each will make N element scans.
 * S: O(log N) -> recursion stack.
 */
class Solution {
    public int maxSubArray(int[] nums) {

        return divideAndConquer(0, nums.length - 1, nums);
    }

    private int divideAndConquer(int start, int end, int[] nums) {

        if (start > end) return Integer.MIN_VALUE;

        int mid = (start + end) / 2;

        int leftBestSum = 0;
        int rightBestSum = 0;
        int curSum = 0;

        // Take sum from middle to left
        for (int i = mid - 1; i >= start; i--) {
            curSum += nums[i];
            leftBestSum = Math.max(leftBestSum, curSum);
        }

        curSum = 0;
        // Take sum from middle to right
        for (int i = mid + 1; i <= end; i++) {
            curSum += nums[i];
            rightBestSum = Math.max(rightBestSum, curSum);
        }

        int totalBestSum = nums[mid] + leftBestSum + rightBestSum;

        // only left best sum
        int leftBest = divideAndConquer(start, mid - 1, nums);
        // only right best sum
        int rightBest = divideAndConquer(mid + 1, end, nums);

        return Math.max(totalBestSum, Math.max(leftBest, rightBest));
    }
}