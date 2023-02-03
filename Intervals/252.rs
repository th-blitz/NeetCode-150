

impl Solution {
    pub fn can_attend_meetings(intervals: Vec<Vec<i32>>) -> bool {
        
        if intervals.len() == 0 {
            return true;
        }
        
        let mut intervals = intervals;
        intervals.sort();
        
        for i in 0..(intervals.len() - 1) {
            if intervals[i][1] > intervals[i + 1][0] {
                return false;
            }
        }
        return true;
    }
}