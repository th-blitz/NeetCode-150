/*
 * Using HashSet.
 * T: O(N)
 * S: O(N)
 *
 * By sorting.
 * T: O(N log N)
 * S: O(1)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}