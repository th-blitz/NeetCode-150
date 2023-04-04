/**
 * Using Max heap
 * T: O(N * log N)
 * S: O(N) - In java converting array to heap takes O(N) space.
 */
// class Solution {
//     public int lastStoneWeight(int[] stones) {

//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

//         for (int stone : stones) {
//             pq.add(stone);
//         }

//         while (pq.size() > 1) {

//             int y = pq.poll();
//             int x = pq.poll();

//             if (x == y) continue;

//             pq.add(y - x);
//         }

//         return pq.isEmpty() ? 0 : pq.poll();
//     }
// }

/**
 * Bucket Sort Algorithm.
 * Pseudo Polynomial Time complexity - because the time complexity is dependent on the numerical value of the input.  Pseudo-polynomial algorithms are useful when there is no "true" polynomial alternative, but in situations such as this one where we have an O(N log⁡ N) alternative (previous approach), they are only useful for very specific inputs.
 * T: O(N + W) -> N - no of stones, W - Max weight of the stone.
 * S: O(W)
 *
 * This solution works well for smaller size of inputs (smaller weight size). Since leetcode test cases have smaller input sizes, this solution is faster. However, for very large inputs, the previous approach is better.
 */
class Solution {
    public int lastStoneWeight(int[] stones) {

        int maxWeight = stones[0];

        for (int stone : stones) {
            maxWeight = Math.max(maxWeight, stone);
        }

        int[] bucket = new int[maxWeight + 1];

        for (int stone : stones) {
            bucket[stone]++;
        }

        int largerWeight = 0;
        int curWeight = maxWeight;

        while (curWeight > 0) {

            if (bucket[curWeight] == 0) {
                curWeight--;
            } else if (largerWeight == 0) {
                bucket[curWeight] %= 2;

                if (bucket[curWeight] == 1) {
                    largerWeight = curWeight;
                }
                curWeight--;
            } else {
                bucket[curWeight]--;

                if (largerWeight - curWeight <= curWeight) {
                    bucket[largerWeight - curWeight]++;
                    largerWeight = 0;
                } else {
                    largerWeight = largerWeight - curWeight;
                }
            }
        }

        return largerWeight;
    }
}