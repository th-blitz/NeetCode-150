/**
 * T: O(N ^ 2)
 * S: O(N)
 */
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLen = 0;

//         if (s == null || s.length() == 0) return maxLen;

//         for (int i = 0; i < s.length(); i++) {

//             int curLen = 0;
//             HashSet<Character> set = new HashSet<>();
//             for (int j = i; j < s.length(); j++) {

//                 if (set.contains(s.charAt(j))) {
//                     break;
//                 }
//                 curLen++;
//                 set.add(s.charAt(j));
//             }
//             maxLen = Math.max(maxLen, curLen);
//         }

//         return maxLen;
//     }
// }

/**
 * Time can be improved by using sliding window.
 * T: O(2 * N) -> worst case each character is visited by both i and j. (To understand this think of the case when input is a,b,c,d,e,f,f)
 * S: O(min(m, n)) -> the upper bound comes from the size of the string and the character set.
 */
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLen = 0;

//         if (s == null || s.length() == 0) return maxLen;

//         int i = 0, j = 0;

//         HashSet<Character> set = new HashSet<>();

//         while (j < s.length()) {

//             if (!set.contains(s.charAt(j))) {
//                 set.add(s.charAt(j));
//                 maxLen = Math.max(maxLen, set.size());
//                 j++;
//             } else {
//                 set.remove(s.charAt(i));
//                 i++;
//             }
//         }

//         return maxLen;
//     }
// }

/**
 * Sliding window time can be improved by using HashMap.
 * T: O(N)
 * S: O(min(m, n)) -> the upper bound comes from the size of the string and the character set.
 */
//  class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int ans = 0;

//         Map<Character, Integer> map = new HashMap<>();

//         for (int j = 0, i = 0; j <  s.length(); j++) {

//             if (map.containsKey(s.charAt(j))) {
//                 // To understand this, analyze the edge case abba.
//                 i = Math.max(map.get(s.charAt(j)) + 1, i);
//             }

//             ans = Math.max(ans, j - i + 1);

//             map.put(s.charAt(j), j);
//         }

//         return ans;
//     }
// }

/**
 * Sliding window time can be improved by using array which has better time for direct access and insertion of elements.
 * T: O(N)
 * S: O(m) -> m is character set size.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        Integer[] items = new Integer[128];

        for (int j = 0, i = 0; j <  s.length(); j++) {

            char c = s.charAt(j);
            if (items[c] != null) {
                // To understand this, analyze the edge case abba.
                i = Math.max(items[c] + 1, i);
            }

            ans = Math.max(ans, j - i + 1);

            items[c] = j;
        }

        return ans;
    }
}
