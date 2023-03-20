/**
 * Using XOR
 * T: O(N)
 * S: O(1)
 */
// class Solution {
//     public int singleNumber(int[] nums) {

//         int result = 0;

//         for (int num : nums) {
//             result = result ^ num;
//         }

//         return result;
//     }
// }

/**
 * Using Math Operation
 * T: O(N)
 * S: O(N)
 */
class Solution {
    public int singleNumber(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }
}