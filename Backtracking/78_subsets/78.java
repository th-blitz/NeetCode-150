/**
 * Cascading - At each step one takes new integer into consideration and generates new subsets from the existing ones.
 * T: O(N * (2 ^ N)) -> to generate all subsets and then copy them into output list.
 * S: O(N * (2 ^ N))
 */
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         // Add empty set
//         result.add(new ArrayList<Integer>());

//         for (int num : nums) {

//             // create new subset adding num to all existing subsets
//             List<List<Integer>> subSet = new ArrayList<List<Integer>>();

//             for (List<Integer> curSet : result) {
//                 // Initialize and assign using double braces
//                 subSet.add(new ArrayList<Integer>(curSet) {{
//                     add(num);
//                 }});
//             }

//             result.addAll(subSet);
//         }

//         return result;
//     }
// }

/**
 * Backtracking - is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
 * T: O(N * (2 ^ N))
 * S: O(N * (2 ^ N))
 */
// class Solution {
//      List<List<Integer>> result = new ArrayList<List<Integer>>();
//      int s;

//      public List<List<Integer>> subsets(int[] nums) {

//          int n = nums.length;

//          // loop to create subset of sizes from 0 (empty set) to n.

//          for (s = 0; s < n + 1; s++) {
//              backtrack(0, new ArrayList<Integer>(), nums);
//          }

//          return result;
//      }

//      private void backtrack(int first, List<Integer> curr, int[] nums) {

//         // backtrack return base
//         if (s == curr.size()) {
//             result.add(new ArrayList<>(curr));
//             return;
//         }

//         for (int l = first; l < nums.length; l++) {
//             curr.add(nums[l]);

//             backtrack(l + 1, curr, nums);

//             curr.remove(curr.size() - 1);
//         }
//      }
// }

/**
 * Using bit operation.
 * T: O(N * (2 * N))
 * S: O(N * (2 * N))
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // Generating all possible bit masks.
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {

            // We are create one extra digit in Most Significant bit (MSB), so we remove it by taking substring(1)
            // int nthBit = 1 << n;
            // for (int i = 0; i < (int) Math.pow(2, n); i++) {
            //     String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
            // }

            // Another way to create a bitmask
            String bitmask = Integer.toBinaryString(i).substring(1);


            ArrayList<Integer> subSet = new ArrayList<Integer>();

            for (int j = 0; j < n; j++) {

                if (bitmask.charAt(j) == '1') {
                    subSet.add(nums[j]);
                }
            }

            result.add(subSet);
        }

        return result;
    }
}