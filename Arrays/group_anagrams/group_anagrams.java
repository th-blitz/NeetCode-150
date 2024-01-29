/**
 * T: O(N * K log K -> sorting) N number of strings, K is longest string length
 * S: O(N * K) -> sorting and hashMap
 */
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {

//         HashMap<String, List<String>> map = new HashMap<>();

//         for (String str : strs) {

//             String sorted = sortString(str);
//             map.computeIfAbsent(sorted, v -> new ArrayList<String>()).add(str);
//         }

//         return new ArrayList<List<String>>(map.values());
//     }

//     String sortString(final String str) {

//         char[] tempString = str.toCharArray();
//         Arrays.sort(tempString);

//         return String.valueOf(tempString);
//     }
// }

/**
 * Counting Sort.
 * T: O(N * K)
 * S: O(N * K)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int[] count = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            Arrays.fill(count, 0);

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append('#').append(count[i]);
            }

            map.computeIfAbsent(sb.toString(), v -> new ArrayList<String>()).add(str);
        }

        return map.values().stream().collect(Collectors.toList());
    }
}