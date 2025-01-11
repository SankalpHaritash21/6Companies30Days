class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k]; 
        int[] index = new int[k]; // Array to store the indices of the chosen elements
        int n = nums.length, j = 0; 
        // PriorityQueue to keep track of the smallest k elements (based on value)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { nums[i], i });
            if (pq.size() > k) { // If there are more than k elements, remove the smallest
                pq.poll();
            }
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        // Extract the elements and their indices from the priority queue
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            hash.put(temp[1], temp[0]); // Store the index as key and value as element
            index[j++] = temp[1]; // Store the index of the element in the index array
        }

        // Sort the indices array to maintain the order of elements as they appear in the original array
        Arrays.sort(index);
        // Populate the result array with the values corresponding to the sorted indices
        for (int i = 0; i < k; i++) {
            ans[i] = hash.get(index[i]);
        }

        return ans;
    }
}