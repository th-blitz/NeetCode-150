#include <vector>
using namespace std;

class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int len = cost.size();
        for (int i = 2; i < len; i++) {
            cost[i] += min(cost[i - 1], cost[i - 2]);
        }
        return min(cost[len - 1], cost[len - 2]);
    }
};