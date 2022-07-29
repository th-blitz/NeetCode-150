#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;


vector<int> hashmap_method(vector<int>& nums, int target) {

    unordered_map<int, int> hashmap;
    vector<int> result = { -1, -1};

    for (int i = 0; i < nums.size(); i++) {
        if (hashmap.count(target - nums[i])) {
            result[0] = hashmap[target - nums[i]];
            result[1] = i;
            return result;
        }
        hashmap[nums[i]] = i;
    }
    return result;

}

void stdout_array(vector<int> nums) {
    
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i] << " ";
    }

}

int main() {
    vector<int> nums = {2,7,11,15};
    vector<int> result;
    int target = 9;

    cout << "test case 1: ";
    stdout_array(nums);
    cout << endl; 
    cout << "target : " << target << endl;
    result = hashmap_method(nums, target);
    cout << "result : ";
    stdout_array(result);
    cout << endl;

    return 0;
}