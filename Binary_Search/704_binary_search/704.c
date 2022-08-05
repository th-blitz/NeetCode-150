#include "stdio.h"

int recur(int left, int right, int* nums, int target) {
    
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


int search(int* nums, int numsSize, int target){
   
    return recur(0, numsSize - 1, nums, target);
}

int main() {

    int nums[] = {-1,0,3,5,9,12};
    int numsSize = 6;
    int target = 9;

    printf("nums : [ ");
    for (int i = 0; i < numsSize; i++) {
        printf("%d ", nums[i]);
    }
    printf(" ]");

    printf(" , numsSize : %d , target : %d , result : %d \n", numsSize, target, search(nums, numsSize, target));

    return 0;
}