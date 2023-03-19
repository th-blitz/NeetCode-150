/**
 * T: O(N)
 * S: O(1)
 */
// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {

//         // first insert the intervals
//         intervals = insertInterval(intervals, newInterval);

//         List<int[]> result = new ArrayList<int[]>();

//         for (int i = 0; i < intervals.length; i++) {

//             int[] currInterval = intervals[i];
//             while (i < intervals.length && checkIfOverlapping(currInterval, intervals[i])) {
//                 currInterval = mergeIntervals(currInterval, intervals[i]);
//                 i++;
//             }
//             i--;

//             result.add(currInterval);
//         }

//         return result.toArray(new int[result.size()][2]);
//     }

//     private int[][] insertInterval(int[][] intervals, int[] newInterval) {

//         List<int[]> intervalList = new ArrayList<int[]>(Arrays.asList(intervals));
//         boolean isInserted = false;

//         for (int i = 0; i < intervals.length; i++) {

//             if (newInterval[0] < intervals[i][0]) {
//                 intervalList.add(i, newInterval);
//                 isInserted = true;
//             }
//         }

//         if (!isInserted) {
//             intervalList.add(newInterval);
//         }

//         return intervalList.toArray(new int[intervalList.size()][2]);
//     }

//     private boolean checkIfOverlapping(int[] interval1, int[] interval2) {

//         return Math.min(interval1[1], interval2[1]) - Math.max(interval1[0], interval2[0]) >= 0;
//     }

//     private int[] mergeIntervals(int[] interval1, int[] interval2) {

//         return new int[] {Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
//     }
// }

/**
 * Using binary serach to find the position the interval has to be inserted
 * T: O(N)
 * S: O(1)
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // first insert the intervals
        intervals = insertInterval(intervals, newInterval);

        List<int[]> result = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {

            int[] currInterval = intervals[i];
            while (i < intervals.length && checkIfOverlapping(currInterval, intervals[i])) {
                currInterval = mergeIntervals(currInterval, intervals[i]);
                i++;
            }
            i--;

            result.add(currInterval);
        }

        return result.toArray(new int[result.size()][2]);
    }

    private int[][] insertInterval(int[][] intervals, int[] newInterval) {

        List<int[]> intervalList = new ArrayList<int[]>(Arrays.asList(intervals));

        int insertIndex = binarySearch(intervals, newInterval);

        if (insertIndex != intervals.length) {
            intervalList.add(insertIndex, newInterval);
        } else {
            intervalList.add(newInterval);
        }

        return intervalList.toArray(new int[intervalList.size()][2]);
    }

    private int binarySearch(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) return 0;

        int ans = intervals.length;
        int start = 0, end = intervals.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (newInterval[0] < intervals[mid][0]) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean checkIfOverlapping(int[] interval1, int[] interval2) {

        return Math.min(interval1[1], interval2[1]) - Math.max(interval1[0], interval2[0]) >= 0;
    }

    private int[] mergeIntervals(int[] interval1, int[] interval2) {

        return new int[] {Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }
}