/**
 * Recursion (bottom-up Approach) - Time limit exceeds.
 * T: O(2 ^ N)
 * S: O(N)
 */
// class Solution {
//     public int climbStairs(int n) {

//         return get_climbs(0, n);
//     }

//     private int get_climbs(int step, int n) {

//         if (step > n) {
//             return 0;
//         }

//         if (step == n) {
//             return 1;
//         }

//         return get_climbs(step + 1, n) + get_climbs(step + 2, n);
//     }
// }

/**
 * Recursion (bottom-up Approach) - with Memorization (DP)
 * T: O(N)
 * S: O(N)
 */
// class Solution {

//     public int climbStairs(int n) {

//         int[] memo = new int[n];

//         return get_climbs(0, n, memo);
//     }

//     private int get_climbs(int step, int n, int[] memo) {

//         if (step > n) {
//             return 0;
//         }

//         if (step == n) {
//             return 1;
//         }

//         if (memo[step] > 0) return memo[step];

//         memo[step] = get_climbs(step + 1, n, memo) + get_climbs(step + 2, n, memo);

//         return memo[step];
//     }
// }

/**
 * Dynamic Programming (bottom-up Approach)
 * T: O(N)
 * S: O(N)
 */
// class Solution {
//     public int climbStairs(int n) {

//         if (n <= 2) return n;

//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;

//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }

/**
 * Fibonacci Number
 * T: O(N)
 * S: O(1)
 */
// class Solution {
//     public int climbStairs(int n) {

//         if (n <= 2) return n;

//         int firstNumber = 1;
//         int secondNumber = 2;

//         for (int i = 3; i <= n; i++) {
//             int third = firstNumber + secondNumber;
//             firstNumber = secondNumber;
//             secondNumber = third;
//         }

//         return secondNumber;
//     }
// }

/**
 * Fibonacci Solution
 * T: O(log N)
 * S: O(1)
 * Formula - https://en.wikipedia.org/wiki/Fibonacci_sequence
 */
// public class Solution {
//     public int climbStairs(int n) {
//         double sqrt5 = Math.sqrt(5);
//         double phi = (1 + sqrt5) / 2;
//         double psi = (1 - sqrt5) / 2;
//         return (int) ((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
//     }
// }

/**
 * Binets Formula
 * T: O(log N) for traversing n bits.
 * S: O(1)
 */
public class Solution {
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
