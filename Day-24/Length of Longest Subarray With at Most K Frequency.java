class Solution {
        public int maxSubarrayLength(int[] A, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; ++j) {
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (count.get(A[j]) > k)
                count.put(A[i], count.get(A[i++]) - 1);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}