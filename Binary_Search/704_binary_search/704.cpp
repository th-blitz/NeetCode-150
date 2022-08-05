#include "iostream"
#include "vector"


int recur(int left, int right, std::vector<int>& nums, int& target) {
        
        if (left > right) {
            return -1;
        }
        
        int mid = (left + right) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } 
        
        if (nums[mid] > target) {
            return recur(left, mid - 1, nums, target);
        }
        return recur(mid + 1, right, nums, target);
    }
    
int search(std::vector<int>& nums, int target) {
    return recur(0, nums.size() - 1, nums, target);
}

void stdout_array(std::vector<int>& nums) {

    for (int i = 0; i < nums.size(); i++) {
        std::cout << nums[i] << " ";
    }

}

int main() {

    std::vector<int> nums = {-1,0,3,5,9,12};
    int target = 9;

    std::cout << "nums : [ ";
    stdout_array(nums);
    std::cout << "], target : " << target << ", result : " << search(nums, target) << std::endl;

    return 0;
}