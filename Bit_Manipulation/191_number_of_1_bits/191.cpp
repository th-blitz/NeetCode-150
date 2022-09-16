#include <stdint.h>
using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int sum = 0;
        while (n != 0) {
            sum += 1;
            n &= (n - 1);
        }
        return sum;
    }
};