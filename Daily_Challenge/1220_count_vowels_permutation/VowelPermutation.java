 class VowelPermutation {
     // The problem is based on state machine.
     // This is a DP problem, where we can formulate the array as
     // dp[i][j] -> the number of strings of length i, that end with jth vowel
     //
     // Rules to be followed: (The number of strings of length i that end with a vowel)
     // a[i] = e[i - 1] + i [i - 1] + u[i - 1]
     // e[i] = a[i - 1] + i [i - 1]
     // i[i] = e[i - 1] + o[i - 1]
     // o[i] = i[i - 1]
     // u[i] = i[i - 1] + o[i - 1]

     // Bottom - up appraoch
     // T: O(N)
     // S: O(N)

     public int countVowelPermutation(int n) {

         long[] aCount = new long[n];
         long[] eCount = new long[n];
         long[] iCount = new long[n];
         long[] oCount = new long[n];
         long[] uCount = new long[n];

         aCount[0] = 1l;
         eCount[0] = 1l;
         iCount[0] = 1l;
         oCount[0] = 1l;
         uCount[0] = 1l;

         int MOD = 1000000007;

         for (int i = 1; i < n; i++) {

             aCount[i] = (eCount[i - 1] + iCount[i - 1] + uCount[i - 1]) % MOD;
             eCount[i] = (aCount[i - 1] + iCount[i - 1]) % MOD;
             iCount[i] = (eCount[i - 1] + oCount[i - 1]) % MOD;
             oCount[i] = (iCount[i - 1]) % MOD;
             uCount[i] = (iCount[i - 1] + oCount[i - 1]) % MOD;
         }

         long result = 0l;

         result = (aCount[n - 1] + eCount[n  - 1] + iCount[n - 1] + oCount[n  - 1] + uCount[n - 1]) % MOD;

         return (int) result;
     }

     public static void main(String[] args) {

         VowelPermutation obj = new VowelPermutation();
         int n;

         if (args == null || args.length == 0) {
             System.out.println("Vowel Permutation Program: ");
             System.out.println("Test Case: 1");
             n = 5;
             System.out.println("n = " + n);
             System.out.println("Number of Vowel Permutations: " + obj.countVowelPermutation(n));

             System.out.println("-------------------------------------");
         }
     }
 }

// class Solution {
//     // The problem is based on state machine.
//     // This is a DP problem, where we can formulate the array as
//     // dp[i][j] -> the number of strings of length i, that end with jth vowel
//     //
//     // Rules to be followed: (The number of strings of length i that end with a vowel)
//     // a[i] = e[i - 1] + i [i - 1] + u[i - 1]
//     // e[i] = a[i - 1] + i [i - 1]
//     // i[i] = e[i - 1] + o[i - 1]
//     // o[i] = i[i - 1]
//     // u[i] = i[i - 1] + o[i - 1]

//     // Bottom - up appraoch
//     // T: O(N)
//     // S: O(1) -> Without having to use array of size n.

//     public int countVowelPermutation(int n) {

//         long aCount = 1;
//         long eCount = 1;
//         long iCount = 1;
//         long oCount = 1;
//         long uCount = 1;

//         int MOD = 1000000007;

//         for (int i = 1; i < n; i++) {

//             long aCountNew = (eCount + iCount + uCount) % MOD;
//             long eCountNew = (aCount + iCount) % MOD;
//             long iCountNew = (eCount + oCount) % MOD;
//             long oCountNew = (iCount) % MOD;
//             long uCountNew = (iCount + oCount) % MOD;

//             aCount = aCountNew;
//             eCount = eCountNew;
//             iCount = iCountNew;
//             oCount = oCountNew;
//             uCount = uCountNew;
//         }

//         long result = 0l;

//         result = (aCount + eCount + iCount + oCount + uCount) % MOD;

//         return (int) result;
//     }
// }

// class Solution {

    // The problem is based on state machine.
    // This is a DP problem, where we can formulate the array as
    // dp[i][j] -> the number of strings of length i, that end with jth vowel
    //
    // Rules to be followed: (The number of strings of length i that end with a vowel)
    // a[i] = e[i - 1] + i [i - 1] + u[i - 1]
    // e[i] = a[i - 1] + i [i - 1]
    // i[i] = e[i - 1] + o[i - 1]
    // o[i] = i[i - 1]
    // u[i] = i[i - 1] + o[i - 1]

    // Top - down appraoch
    // T: O(N) -> There is 5 * O(N) recursive calls.
    // S: O(N) -> There is 5 * O(N) stack space used by recursive calls.

//    private long[][] memo;
//    private int MOD = 1000000007;
//    public int countVowelPermutation(int n) {
//        // each row stands for the length of string
//        // each column indicates the vowels
//        // specifically, a: 0, e: 1, i: 2, o: 3, u: 4
//        memo = new long[n][5];
//        long result = 0;
//        for (int i = 0; i < 5; i++){
//            result = (result + vowelPermutationCount(n - 1, i)) % MOD;
//        }
//        return (int)result;
//    }
//
//    public long vowelPermutationCount(int i, int vowel) {
//        if (memo[i][vowel] != 0) return memo[i][vowel];
//        if (i == 0) {
//            memo[i][vowel] = 1;
//        } else {
//            if (vowel == 0) {
//                memo[i][vowel] = (vowelPermutationCount(i - 1, 1) + vowelPermutationCount(i - 1, 2) + vowelPermutationCount(i - 1, 4)) % MOD;
//            } else if (vowel == 1) {
//                memo[i][vowel] = (vowelPermutationCount(i - 1, 0) + vowelPermutationCount(i - 1, 2)) % MOD;
//            } else if (vowel == 2) {
//                memo[i][vowel] = (vowelPermutationCount(i - 1, 1) + vowelPermutationCount(i - 1, 3)) % MOD;
//            } else if (vowel == 3) {
//                memo[i][vowel] = vowelPermutationCount(i - 1, 2);
//            } else if (vowel == 4) {
//                memo[i][vowel] = (vowelPermutationCount(i - 1, 2) + vowelPermutationCount(i - 1, 3)) % MOD;
//            }
//        }
//        return memo[i][vowel];
//    }
//}

