#include <vector>
using namespace std;

int max(int a, int b) {
    if (a > b) return a;
    return b;
}
    
int maxSubArray(vector<int>& nums) {
    int current_sum = nums[0];
    int max_sum = nums[0];
    for (int i = 1; i < nums.size(); i++) {
        if (current_sum < 0) current_sum = nums[i];
        else current_sum += nums[i];
        max_sum = max(current_sum, max_sum);
    }
    return max_sum;
}