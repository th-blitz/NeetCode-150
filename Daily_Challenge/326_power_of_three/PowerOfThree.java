// class Solution {
//     // Basic solution
//     // Using while loop

//     // T: O(log N to base 3)
//     // S: O(1)

//     public boolean isPowerOfThree(int n) {

//         if (n < 1) return false;

//         while (n % 3 == 0) {
//             n /= 3;
//         }

//         return n == 1;
//     }
// }

// class Solution {
//     // Basic solution
//     // Using while loop

//     // T: O(log N to base 3)
//     // S: O(log N to base 3) // The string of base 3 representation and regex string

//     public boolean isPowerOfThree(int n) {

//          return Integer.toString(n, 3).matches("^10*$");
//     }
// }

// class Solution {
//     // Beware of double precision errors.

//     // T: Depends on the language
//     // S: O(log N to base 3) // The string of base 3 representation and regex string

//     public boolean isPowerOfThree(int n) {

//          return (Math.log10(n) / Math.log10(3)) % 1 == 0;
//         // return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
//     }
// }

class Solution {
    // Math solution

    // T: O(1)
    // S: O(1)
    // For a given n which is int, the max value of n that can be power of 3 is
    // 3 ^ 19 = 1162261467
    // Since 3 is prime, 3 ^ 19 divisors are only 3 ^ 0, 3 ^ 1, ....
    public boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;
    }
}

// Order of performance faster to slowest
// Math solution -> Naive while loop -> log solution -> String solution