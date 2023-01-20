
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

int diagonals[][2] = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};

struct result_stack {
    char** chessboard;
    struct result_stack* next;
};

struct result_stack* Node() {
    struct result_stack* node = (struct result_stack*)malloc(sizeof(struct result_stack));
    node -> next = NULL;
    node -> chessboard = NULL;
    return node;
}

void toggle_queen(char** chessboard, int n, int row, int col, char toggle) {

    for (int i = 0; i < n; i++) chessboard[row][i] += toggle;
    for (int j = 0; j < n; j++) chessboard[j][col] += toggle;

    for (int x; x < 4; x++) {
        int i = row + diagonals[x][0];
        int j = col + diagonals[x][1];
        while (i >= 0 && i < n && j >= 0 && j < n) {
            chessboard[i][j] += toggle;
            i += diagonals[x][0];
            j += diagonals[x][1];
        }
    }
    chessboard[row][col] -= 3 * toggle;
}

char** copy_board(char** chessboard, int n) {

    char** copy = (char**)malloc(n * sizeof(char*));
    for(int i = 0; i < n; i++) {
        copy[i] = (char*)malloc((n + 1) * sizeof(char));
        for(int j = 0; j < n; j++) {
            chessboard[i][j] == -1 ? (copy[i][j] = 'Q') : (copy[i][j] = '.');
        }
        copy[i][n] = '\0';
    } 
    return copy;
}

int backtrack(struct result_stack* stack, char** chessboard, int n, int row) {

    if (row == n) {
        struct result_stack* node = Node();
        node -> chessboard = copy_board(chessboard, n);
        node -> next = stack -> next;
        stack -> next = node;
        return 1;
    }

    int result_size = 0;
    for (int col = 0; col < n; col++) {
        if (chessboard[row][col] == 0) {
            toggle_queen(chessboard, n, row, col, 1);
            result_size += backtrack(stack, chessboard, n, row + 1);
            toggle_queen(chessboard, n, row, col, -1);
        }
    }
    return result_size;
}


char *** solveNQueens(int n, int* returnSize, int** returnColumnSizes){

    char** chessboard = (char**)malloc(n * sizeof(char*));
    for(int i = 0; i < n; i++) {
        chessboard[i] = (char*)malloc(n * sizeof(char));
        for(int j = 0; j < n; j++) {
            chessboard[i][j] = 0;
        }
    } 

    struct result_stack* stack = Node();

    *returnSize = backtrack(stack, chessboard, n, 0);

    char*** result = (char***)malloc(*returnSize * sizeof(char**));
    *returnColumnSizes = (int*)malloc(*returnSize * sizeof(int));
   
    for (int i = 0; i < *returnSize; i++) {
        returnColumnSizes[0][i] = n;
        result[i] = stack -> next -> chessboard;
        struct result_stack* deletenode = stack -> next;
        stack -> next = stack -> next -> next;
        free(deletenode);
    }
    free(stack);

    for (int row = 0; row < n; row++) {
        free(chessboard[row]);
    }
    free(chessboard);

    return result;
}

