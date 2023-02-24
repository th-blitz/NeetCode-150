


int recur(int x, int y, int** mem) {
    
    if (mem[x][y] > 0) { return mem[x][y]; }
    
    if ((x == 0) && (y == 0)) { return 1; }

    int result = 0;
    if ((x - 1 >= 0) && (y >= 0)) {
        result += recur(x - 1, y, mem);
    }
    if ((y - 1 >= 0) && (x >= 0)) {
        result += recur(x, y - 1, mem);
    }
    mem[x][y] = result;
    return result;
}


int uniquePaths(int m, int n){
    
    int** mem = (int**)malloc(sizeof(int*) * m);
    for (int i = 0; i < m; i++) { mem[i] = (int*)malloc(sizeof(int) * n); }

    return recur(m - 1, n - 1, mem);
}
