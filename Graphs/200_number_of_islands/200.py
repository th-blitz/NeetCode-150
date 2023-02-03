


def numIslands(grid):

    rows = len(grid)
    cols = len(grid[0])

    directions = ((0, 1), (0, -1), (1, 0), (-1, 0))
    count = 0

    def search(row, col):
        if row >= 0 and col >= 0 and row < rows and col < cols and grid[row][col] == '1':
            for direction in directions:
                search(row + direction[0], col +  direction[1])
                grid[row][col] = '0'

    for row in range(rows):
        for col in range(cols):
            if grid[row][col] == '1':
                search(row, col)
                count += 1

    return count
