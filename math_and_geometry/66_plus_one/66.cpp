
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
      
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        vector<int> result(digits.size() + 1, 1);
        for (int i = 0; i < result.size() - 1; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
};