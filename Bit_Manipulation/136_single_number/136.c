int singleNumber(int* nums, int numsSize){
    
    int a = 0;
    for (int i = 0; i < numsSize; i++) {
        a ^= nums[i];
    }
    return a;
}