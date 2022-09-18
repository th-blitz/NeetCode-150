#include <vector>
using namespace std;

class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> result(n + 1, 0);
        for (int i = 1; i < n + 1; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
};