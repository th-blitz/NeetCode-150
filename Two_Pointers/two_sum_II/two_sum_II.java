/**
 * Using HashMap. This is work for un sorted array as well.
 * T: O(N)
 * S: O(N)
 */
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < numbers.length; i++) {

//             int secNum = target - numbers[i];

//             if (map.containsKey(secNum)) {
//                 return new int[] {map.get(secNum), i + 1};
//             }
//             map.put(numbers[i], i + 1);
//         }

//         return new int[] {-1, -1};
//     }
// }

/**
 * Since the array is sorted, we can improve on the space.
 * T: O(N)
 * S: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Similar to two sum problem, but here the array is sorted.
        // T: O(n), M: O(1)
        // Integer overflow can occur when adding low and high values.
        // We can use Long to store the sum value, or we can check if the sum will cause an overflow by using the condition,
        // numbers[low] > (1 << 31) - 1 - numbers[high], if this is true then the sum will cause an overflow, so we move to the left on the high side.


        int low = 0, high = numbers.length - 1;

        while (low <= high) {

            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[] {low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[] {-1, -1};
    }
}