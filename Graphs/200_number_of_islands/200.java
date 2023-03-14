/**
 * DFS Solution
 * T: O(M * N)
 * S: O(M * N) recursive space
 */
// class Solution {
//     public int numIslands(char[][] grid) {

//         if (grid == null || grid.length == 0) return 0;

//         int row = grid.length;
//         int col = grid[0].length;

//         int result = 0;

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {

//                 if (grid[i][j] == '1') {
//                     countIslands(grid, i, j);
//                     result++;
//                 }
//             }
//         }

//         return result;
//     }

//     private void countIslands(char[][] grid, int row, int col) {

//         if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;

//         grid[row][col] = '0';

//         countIslands(grid, row - 1, col);
//         countIslands(grid, row + 1, col);
//         countIslands(grid, row, col - 1);
//         countIslands(grid, row, col + 1);
//     }
// }

/**
 * BFS Solution
 * T: O(M * N)
 * S: Min (M, N)
 * Simple attempt at understanding why the space complexity is min(M,N) in BFS.
 * An image is worth 1000 lines :) https://imgur.com/gallery/M58OKvB
 */
// class Solution {

//     private static final List<int[]> DIRECTIONS = Arrays.asList(
//         new int[] {0, 1},
//         new int[] {0, -1},
//         new int[] {1, 0},
//         new int[] {-1, 0}
//     );

//     public int numIslands(char[][] grid) {

//         if (grid == null || grid.length == 0) return 0;

//         int row = grid.length;
//         int col = grid[0].length;

//         int result = 0;

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {

//                 if (grid[i][j] == '1') {
//                     countIslands(grid, i, j);
//                     result++;
//                 }
//             }
//         }

//         return result;
//     }

//     private void countIslands(char[][] grid, int row, int col) {

//         grid[row][col] = '0';
//         Queue<int[]> queue = new LinkedList<int[]>();
//         queue.add(new int[] {row, col});

//         while (!queue.isEmpty()) {
//             int[] point = queue.poll();
//             int r = point[0];
//             int c = point[1];

//             for (int[] d : DIRECTIONS) {
//                 int curR = r + d[0];
//                 int curC = c + d[1];

//                 if (curR < 0 || curR >= grid.length || curC < 0 || curC >= grid[0].length || grid[curR][curC] == '0') {
//                     continue;
//                 }

//                 grid[curR][curC] = '0';
//                 queue.add(new int[] {curR, curC});
//             }
//         }
//     }
// }

/**
 * Union Find data structure
 * T: O(M X N)
 * S: O(M X N)
 */
class Solution {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int[] rep = new int[row * col];
        int components = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rep[i * col + j] = i * col + j;
                if (grid[i][j] == '1') {
                    components++;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1') {

                    grid[i][j] = '0';

                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        components -= union(rep, i * col + j, (i - 1) * col + j);
                    }

                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        components -= union(rep, i * col + j, (i + 1) * col + j);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        components -= union(rep, i * col +  j, i * col + (j - 1));
                    }

                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        components -= union(rep, i * col +  j, i * col + (j + 1));
                    }
                }
            }
        }

        return components;
    }

    private int find(int[] rep, int x) {

        if (rep[x] == x) return x;

        return find(rep, rep[x]);
    }

    private int union(int[] rep, int x, int y) {

        int r1 = find(rep, x);
        int r2 = find(rep, y);

        if (r1 == r2) return 0;

        if (r1 > r2) {
            rep[r1] = r2;
        } else {
            rep[r2] = r1;
        }

        return 1;
    }
}