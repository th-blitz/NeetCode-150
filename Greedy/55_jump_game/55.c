

bool canJump(int* nums, int numsSize){
    int good_position = numsSize - 1;
    for (int i = numsSize - 1; i >= 0; i--) {
        if (i + nums[i] >= good_position) {
            good_position = i;
        }
    }
    return good_position == 0;
}