import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class BinaryFactors {

    // The speciality of 1_000_000_007 has to do with the fact that it is a large prime number that is close to 1 Billion and fits in 32 bit integer.

    // The root is always the largest value
    // If root is (v) then v = x * y (where x and y are its children)
    // dp[i] -> The number of possible trees with root node of A[i]
    // Its children will be A[j] and A[i] / A[j] = A[k]
    // Then dp[i] = dp[i] + dp[j] + dp[k]

    //class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int N = arr.length;
        // we use long to prevent overflow
        long[] dp = new long[N];
        Arrays.sort(arr);

        // Since each value can be it self binary tree with root node only
        Arrays.fill(dp, 1);

        int MOD = 1000000007;

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // A[j] will become left node
                if (arr[i] % arr[j] == 0) {
                    // Check if right node exists
                    int right = arr[i] / arr[j];
                    if (indexMap.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[indexMap.get(right)]) % MOD;
                    }
                }
            }
        }

        long result = 0;

        for (long num : dp) {
            result += num;
        }

        return (int) (result % MOD);
    }
    //}

    public static void main(String[] args) {
        BinaryFactors obj = new BinaryFactors();
        int[] nums = new int[] {2,4,5,10};

        if (args == null || args.length == 0) {
            System.out.println("Binary Factors: ");
            System.out.println("Test Case: 1");
            System.out.println("Array = [2,4,5,10]");
            System.out.println("Number of Binary Trees Possible: " + obj.numFactoredBinaryTrees(nums));

            System.out.println("-------------------------------------");
        }
    }
}