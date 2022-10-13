

class Solution {
public:

    int idx(char x) {
        int idx = int(x) - 32;
        return idx;
    }

    int lengthOfLongestSubstring(string s) {
        vector<bool> window(96, false);
        int max_count = 0;
        int count = 0;

        int i = 0;
        int j = 0;
        while (j < s.size()) {
            if ((i == j) || (window[idx(s[j])] == false)) {
                window[idx(s[j])] = true;
                count += 1;
                max_count = max(count, max_count);
                j += 1;
            } else {
                window[idx(s[i])] = false;
                count -= 1;
                i += 1;
            }
        }
        return max_count;
    }
};
