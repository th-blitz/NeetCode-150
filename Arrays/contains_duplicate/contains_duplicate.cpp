
#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

bool contains_duplicate_hashset(vector<int> nums) {
    
    unordered_set<int> hashset;

    for (int i = 0; i < nums.size(); i++) {
        if (hashset.count(nums[i])) {
            return true;
        }
        hashset.insert(nums[i]);
    }
    return false;
}

bool contains_duplicate_bruteforce(vector<int> nums) {
    
    int i = 0, j = 0;

    for (i = 0; i < nums.size(); i++) {
        for (j = i + 1; j < nums.size(); j++) {
            if (nums[j] == nums[i]) {
                return true;
            }
        }
    }
    return false;
}

void stdout_array(vector<int> nums) {
    
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i] << " ";
    }

}

int main() {
    
    vector<int> nums_1 = {1, 2, 3, 4, 5, 6};
    vector<int> nums_2 = {1, 2, 2, 3, 4, 5};

    cout << "test case 1: ";
    stdout_array(nums_1);
    cout << endl; 
    
    cout << "test case 2: ";
    stdout_array(nums_2); 
    cout << endl;

    cout << "brute force 1: " << contains_duplicate_bruteforce(nums_1) << endl;
    cout << "brute force 2: " << contains_duplicate_bruteforce(nums_2) << endl;

    cout << "hashset 1: " << contains_duplicate_hashset(nums_1) << endl;
    cout << "hashset 2: " << contains_duplicate_hashset(nums_2) << endl;


    return 0;
}