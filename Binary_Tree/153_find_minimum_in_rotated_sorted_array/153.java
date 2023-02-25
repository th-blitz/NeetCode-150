/**
 * 1. Ask if the elements are unique?
 *
 * T: O(log N)
 * S: O(1)
 **/
class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 1) return nums[0];

        // Array is not rotated
        if (nums[high] > nums[low]) return nums[low];

        int firstElement = nums[low];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid element greater than next element then next element is lowest
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // If mid element is less than previous element then mid is lowest
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > firstElement) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}