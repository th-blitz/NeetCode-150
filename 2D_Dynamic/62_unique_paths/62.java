/**
 * Recursive Solution
 * T: O(2 ^ M)
 * S: O(M)
 */
// class Solution {
//     public int uniquePaths(int m, int n) {

//         if (m == 1 || n == 1) return 1;

//         return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//     }
// }

/**
 * Dynamic programming (Bottom - up approach)
 * T: O(M x N)
 * S: O(M x N)
 */
// class Solution {
//     public int uniquePaths(int m, int n) {

//         int[][] dp = new int[m][n];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {

//                 if (i == 0) {
//                     dp[i][j] = 1;
//                     continue;
//                 }

//                 if (j == 0) {
//                     dp[i][j] = 1;
//                     continue;
//                 }

//                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//             }
//         }

//         return dp[m - 1][n - 1];
//     }
// }

/**
 * Dynamic programming (Bottom - up approach) - Space optimized
 * T: O(M x N)
 * S: O(M)
 */
// class Solution {
//     public int uniquePaths(int m, int n) {

//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {

//                 dp[j] = dp[j] + dp[j - 1];
//             }
//         }

//         return dp[n - 1];
//     }
// }

/**
 * Math - Binomial Co-effeciant Problem.
 * T: O((M + N)(log (M + N) log log(M + N)) ^ 2)
 * S: O(1)
 */