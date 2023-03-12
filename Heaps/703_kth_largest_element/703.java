/**
 * Using Max heap
 * T: O(N * log N + M * log (k))
 * S: O(N)
 */
class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();

        for (int num : nums) {
            this.pq.offer(num);

            if (this.pq.size() > this.k) {
                this.pq.poll();
            }
        }
    }

    public int add(int val) {

        this.pq.add(val);

        if (this.pq.size() > this.k) {
            this.pq.poll();
        }

        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */