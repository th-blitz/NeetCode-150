
#include <vector>
#include <iostream>


std::vector<int> twoSum(std::vector<int> &numbers, int target) {

    std::vector<int> result = {-1, -1};
    int i = 0;
    int j = numbers.size() - 1;

    while (i < j) {
        if ((numbers[i] + numbers[j]) == target) {
            result[0] = i+1;
            result[1] = j+1;
            return result;
        }
        if ((numbers[i] + numbers[j]) < target) {
            i++;
        } else {
            j--;
        }
    }

    return result;
}

void stdout_array(std::vector<int> &nums) {
    
    for (int i = 0; i < nums.size(); i++) {
        std::cout << nums[i] << " ";
    }

}

int main() {

    int target = 9;
    std::vector<int> numbers = {2,7,11,15};

    std::vector<int> result = twoSum(numbers, target);

    std::cout << "result : ";
    stdout_array(result);
    std::cout << std::endl;

    return 0;
}