#include <vector>
#include <iostream>
using namespace std;


int recur(int index, vector<int>& nums, vector<int>& memory) {
        if (memory[index] > 0) {
            return memory[index];
        }
        int max_depth = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < nums[index]) {
                max_depth = max(max_depth, recur(i, nums, memory));
            }
        }
        memory[index] = max_depth + 1;
        return memory[index];
    }
    
    
int lengthOfLIS(vector<int>& nums) {
    
    vector<int> memory(nums.size(), 0);
    
    int max_depth = 0;
    for (int i = nums.size() - 1; i >= 0; i--) {
        max_depth = max(max_depth, recur(i, nums, memory));            
    }
    
    return max_depth;
}

void stdout_array(vector<int>& nums) {
    cout << "{ ";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i < (nums.size() - 1)) {
            cout << ", ";
        }
    }
    cout << " }";
}

int main() {

    vector<int> nums = {10,9,2,5,3,7,101,18};
    cout << "nums : ";
    stdout_array(nums);
    cout << " | result : " << lengthOfLIS(nums) << endl;
    return 0;
}