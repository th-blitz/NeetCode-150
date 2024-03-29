
impl Solution {
    pub fn unique_paths(m: i32, n: i32) -> i32 {
        
        let mut memory: Vec<Vec<usize>> = vec![vec![0;n as usize];m as usize];
        
        fn recur(x: usize, y: usize, memory: &mut Vec<Vec<usize>>) -> usize {
            
            if memory[x][y] > 0 {
                return memory[x][y];
            }
            
            if (x == 0) && (y == 0) {
                return 1 as usize;
            }
            
            let mut result: usize = 0;
            
            if x != 0 {
                if x - 1 >= 0 {
                    result += recur(x - 1, y, memory);
                }
            }
            if y != 0 {
                if y - 1 >= 0 {
                    result += recur(x, y - 1, memory);
                }   
            }
            
            memory[x][y] = result;
            return result;  
            
        }
    
        let result = recur((m - 1) as usize, (n - 1) as usize, &mut memory);
        
        return result as i32;
        
    }
}