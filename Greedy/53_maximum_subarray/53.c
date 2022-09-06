

int max(int a, int b) {
    if ( a > b ) return a;
    return b;
}

int maxSubArray(int* nums, int numsSize){
    int current_sum = nums[0];
    int max_sum = nums[0];
    for (int i = 1; i < numsSize; i++) {
        if (current_sum < 0) current_sum = nums[i];
        else current_sum += nums[i];
        max_sum = max(max_sum, current_sum);
    }
    return max_sum;
}