class CombinationSum {

    // class Solution {
//     // Recursive top down approach
//     // With out memorization gives us timeout
//     // T: O(N ^ target)
//     // S: O(target)
//     public int combinationSum4(int[] nums, int target) {

//         if (target == 0) return 1;

//         int res = 0;
//         for (int i : nums) {
//             if (i <= target) {
//                 res += combinationSum4(nums, target - i);
//             }
//         }

//         return res;
//     }
// }

// class Solution {
//     // Recursive top down approach
//     // Now with memorization
//     // T: O(N * target)
//     // S: O(target)
//     int[] dp;

//     public int combinationSum4(int[] nums, int target) {

//         dp = new int[target + 1];

//         // we fill with -1 and not zero because its possible that we can have a target that have zero combinations
//          Arrays.fill(dp, -1);

//         // base case
//         dp[0] = 1;

//         getCombinationSum(nums, target);

//         return dp[target];
//     }

//     private int getCombinationSum(int[] nums, int target) {

//         if (dp[target] != -1) {
//             return dp[target];
//         }

//         int res = 0;
//         for (int i : nums) {
//             if (i <= target) {
//                 res += getCombinationSum(nums, target - i);
//             }
//         }

//         dp[target] = res;

//         return res;
//     }
// }


        // DP bottom up approach
        // T: O(N * target)
        // S: O(target)

    int[] dp;

    public int combinationSum4(int[] nums, int target) {

        dp = new int[target + 1];

        // base case
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {

                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }


// Follow up Questions
// What if we have negative numbers?
// Then we can have infinite number of combinations.
// Example: nums[1, -1], target = 1; (Here we can have infinite number of 1 and -1 ending with 1, therefore we need to have certain restrictions, like the number of times each number could be used).

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] nums;
        int target;

        if (args == null || args.length == 0) {
            System.out.println("Combination Sum Program: ");
            System.out.println("Test Case: 1");
            nums = new int[]{1, 2, 3};
            target = 4;
            System.out.println("Nums = " + nums + " Target = " + target);
            System.out.println("Number of comibnations: " + obj.combinationSum4(nums, target));

            System.out.println("-------------------------------------");
        }
    }
}