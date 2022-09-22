

int climbStairs(int n){
    if (n == 1) {
        return 1;
    }
    int* dp = (int*)malloc(sizeof(int) * n);
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    int result = dp[n - 1];
    free(dp);
    return result;
}