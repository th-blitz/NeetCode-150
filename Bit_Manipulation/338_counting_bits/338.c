

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* countBits(int n, int* returnSize){
    
    *returnSize = n + 1;
    int* result = (int*)malloc((n + 1) * sizeof(int));
    result[0] = 0;
    for (int i = 1; i < (n + 1); i++) {
        result[i] = 0;
        result[i] = result[i & (i - 1)] + 1;
    }
    return result;
}