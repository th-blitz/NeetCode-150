

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    *returnSize = digitsSize;
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] == 9) {
            digits[i] = 0;
        } else {
            digits[i] += 1;
            return digits;
        }
    }
    *returnSize += 1;
    int* result = (int *)malloc(*returnSize * sizeof(int));
    result[0] = 1;
    for (int i = 0; i < *returnSize - 1; i++) {
        result[i + 1] = digits[i];
    }
    return result;
}