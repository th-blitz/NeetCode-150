#include "iostream"
#include "vector"
#include "unordered_map"


int recur(int target, std::vector<int>& nums, std::unordered_map<int, int>& memoize) {
        
        if (memoize.count(target)) {
            return memoize[target];
        }
        
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += recur(target - nums[i], nums, memoize);
        }
        memoize[target] = result;
        return result;
    }
    
int combinationSum4(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> memoize;
    return recur(target, nums, memoize);
}

void stdout_array(std::vector<int>& nums) {
    for (int i = 0; i < nums.size(); i++) {
        std::cout << nums[i] << " ";
    }
}

int main() {

    std::vector<int> nums = {1,2,3,8,7,5,9};
    int target = 10;

    std::cout << "nums : ";
    stdout_array(nums);
    std::cout << ", target : " << target << " | result : " << combinationSum4(nums, target) << std::endl;

    return 0;
}
