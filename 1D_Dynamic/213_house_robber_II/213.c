

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

int robbing(int* nums, int i, int j) {
    int first = 0;
    int second = 0;
    int temp;
    for (int k = i; k < j; k++) {
        temp = first;
        first = max(nums[k] + second, first);
        second = temp;
    }
    return first;
}

int rob(int* nums, int numsSize){
    if (numsSize == 1) return nums[0];
    return max(robbing(nums, 1, numsSize), robbing(nums, 0, numsSize - 1));
}