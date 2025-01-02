class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k)- atMost(nums, k-1);
    }

    public int atMost(int []A, int k){
        int r= 0, i=0, n=A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            r += j - i + 1;
        }
        return r;
    }
}