class KthLargest {
    private int k;
     private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap= new PriorityQueue<>();
        for(int i: nums){
            if(minHeap.size()< k){
                minHeap.offer(i);
            }
            else if(i > minHeap.peek()){
                minHeap.offer(i);
                if(minHeap.size()>k){
                    minHeap.poll();
                }
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.offer(val);
        }else if(val > minHeap.peek()){
            minHeap.offer(val);
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */