class Solution {
        private int comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        long res = 1;
        for (int i = 0; i < k; ++i)
            res = res * (n - i) / (i + 1);
        return (int)res;
    }

    public int waysToReachStair(int k) {
        int res = 0;
        for (int j = 0; j < 31; j++)
            res += comb(j + 1, (1 << j) - k);
        return res;
    }
}