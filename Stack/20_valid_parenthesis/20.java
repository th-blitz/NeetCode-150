/**
 * T: O(N)
 * S: O(N)
 */
class Solution {
    public boolean isValid(String s) {

        if(s == null || s.length() == 0) return true;

        char[] brackets = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < brackets.length; i++) {

            switch(brackets[i]) {
                case '(' : stack.push(')');
                    break;
                case '{' : stack.push('}');
                    break;
                case '[' : stack.push(']');
                    break;
                default: if (stack.empty() || stack.pop() != brackets[i]) return false;
            }
        }
        return stack.empty();
    }
}