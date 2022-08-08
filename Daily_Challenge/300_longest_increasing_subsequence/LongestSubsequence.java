import java.util.List;
import java.util.ArrayList;

class LongestSubsequence {

    // class Solution {
//     // DP problem
//     // bottom - up approach
//     // T: O(N ^ 2) -> two loops
//     // S: O(N)

//     public int lengthOfLIS(int[] nums) {

//         int len = nums.length;

//         int[] dp = new int[len];
//         Arrays.fill(dp, 1);

//         for (int i = 1; i < len; i++) {
//             for (int j = 0; j < i; j++) {

//                 if (nums[i] > nums[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//         }

//         int max = 0;
//         for (int num : dp) {
//             max = Math.max(max, num);
//         }

//         return max;
//     }
// }

// class Solution {
//     // DP problem
//     // bottom - up approach
//     // T: O(N ^ 2) -> In worst case only
//     // S: O(N) -> If the input is strictly increasing, then the result will be nums

//     public int lengthOfLIS(int[] nums) {

//         List<Integer> result = new ArrayList<Integer>();

//         result.add(nums[0]);

//         for (int i = 1; i < nums.length; i++) {

//             if(nums[i] > result.get(result.size() - 1)) {
//                 result.add(nums[i]);
//             } else {

//                 int j = 0;
//                 while (nums[i] > result.get(j)) {
//                     j++;
//                 }

//                 result.set(j, nums[i]);
//             }
//         }

//         return result.size();
//     }
// }

    //class Solution {
        // DP problem
        // bottom - up approach
        // Instead of searching linearly, we improve the effeciency by doing binary search.
        // T: O(N * log N) -> log N for binary search
        // S: O(N) -> If the input is strictly increasing, then the result will be nums

        public int lengthOfLIS(int[] nums) {

            List<Integer> result = new ArrayList<Integer>();

            result.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {

                if(nums[i] > result.get(result.size() - 1)) {
                    result.add(nums[i]);
                } else {

                    int j = binarySearch(result, nums[i]);
                    result.set(j, nums[i]);
                }
            }

            return result.size();
        }

        private int binarySearch(List<Integer> result, int num) {
            int left = 0;
            int right = result.size() - 1;
            int mid = (left + right) / 2;

            while (left < right) {

                mid = (left + right) / 2;
                if (result.get(mid) == num) {
                    return mid;
                }

                if (result.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    //}

    public static void main(String[] args) {

        LongestSubsequence obj = new LongestSubsequence();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};

        if (args == null || args.length == 0) {
            System.out.println("Longest Subsequence Program: ");
            System.out.println("Test Case: 1");
            System.out.println("nums = [10,9,2,5,3,7,101,18]");
            System.out.println("Longest subsequence: " + obj.lengthOfLIS(nums));

            System.out.println("-------------------------------------");
        }
    }
}