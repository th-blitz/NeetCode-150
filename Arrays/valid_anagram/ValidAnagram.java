// Ask Interviewer for lowercase or uppercase characters
// Ask about unicode characters

// Solution 1:
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         // T: O(N)
//         // S: O(1) , although we use extra space, it is constant, and does not depend on size of input.

//         if (s.length() != t.length()) {
//             return false;
//         }

//         int[] count = new int[26];

//         for (int i = 0; i < s.length(); i++) {
//             count[s.charAt(i) - 'a']++;
//             count[t.charAt(i) - 'a' ]--;
//         }

//         for (int c : count) {
//             if (c != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

// Solution 2:
// class Solution {
//     // T: O(N log N) -> N log N for sorting, N for comparing
//     // S: O(1) -> Depends on type of sorting. If heapsort is used, then it is O(1), Java
//     // needs O(N) for toCharArray(). Makes a copy of the string so it costs O(n)O(n) extra space, but we ignore this for complexity analysis because it is language dependent.

//     public boolean isAnagram(String s, String t) {

//         if (s.length() != t.length()) {
//             return false;
//         }

//         char[] sArray = s.toCharArray();
//         char[] tArray = t.toCharArray();

//         Arrays.sort(sArray);
//         Arrays.sort(tArray);

//         return Arrays.equals(sArray, tArray);
//     }
// }

import java.util.HashMap;
import java.util.Map;
class ValidAnagram {
    // This handels unicode characters as well
    // S: O(N) because of hashMap
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){return false;}
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        String s, t;

        if (args == null || args.length == 0) {
            System.out.println("Valid Anagram Program: ");
            System.out.println("Test Case: 1");
            s = "anagram";
            t = "nagaram";
            System.out.println("S = " + s + " T = " + t);
            System.out.println("IsAnagram: " + obj.isAnagram(s, t));

            System.out.println("-------------------------------------");

            System.out.println("Test Case: 2");
            s = "anagrat";
            t = "cagaram";
            System.out.println("S = " + s + " T = " + t);
            System.out.println("IsAnagram: " + obj.isAnagram(s, t));
        } else {
            System.out.println("Arguments Passed: ");
            s = args[0];
            t = args[1];
            System.out.println("S = " + s + " T = " + t);
            System.out.println("IsAnagram: " + obj.isAnagram(s, t));
        }
    }
}