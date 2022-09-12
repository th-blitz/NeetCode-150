impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let rows: usize = grid.len();
        let cols: usize = grid[0].len();
    
        let directions: Vec<(isize, isize)> = vec!((-1, 0), (0, 1), (1, 0), (0, -1));
        
        fn rotting_process(grid: &mut Vec<Vec<i32>>, rows: &usize, cols: &usize, directions: &Vec<(isize, isize)>, timestamp: i32) -> bool {
            let mut continue_process: bool = false;
            for row in 0..*rows {
                for col in 0..*cols {
                    if grid[row][col] == timestamp {
                        for (mut r, mut c) in directions.iter() {
                            r += row as isize;
                            c += col as isize;
                            if *rows as isize > r && r >= 0 && *cols as isize > c && c >= 0 && grid[r as usize][c as usize] == 1 {
                                grid[r as usize][c as usize] = timestamp + 1;
                                continue_process = true;
                            }
                        }
                    }
                }
            }
            return continue_process;
        }
        
        let mut timestamp: i32 = 2;
        let mut grid = grid;
        while rotting_process(&mut grid, &rows, &cols, &directions, timestamp) {
            timestamp += 1;
        }
        
        for row in grid.iter() {
            for cell in row.iter() {
                if *cell == 1 {
                    return -1;
                }
            }
        }
        
        return timestamp - 2;
    
    }
}