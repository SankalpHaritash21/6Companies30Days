class Solution {
    int MOD = (int)1e9 + 7;
    public int squareFreeSubsets(int[] nums) {
        int[][] dp = new int[1010][1 << 11];
        for (int[] d : dp) Arrays.fill(d, -1);

        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        int[] numsPrimeMask = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsPrimeMask[i] = computeMask(nums[i], primes);
        }

        // error one : return dfs(0, 1, numsPrimeMask, dp) - 1;
        return (dfs(0, 1, numsPrimeMask, dp) - 1 + MOD) % MOD;
    }

    private int dfs(int pos, int productMask, int[] numsPrimeMask, int[][] dp) {
        if (pos >= numsPrimeMask.length) return 1;

        if (dp[pos][productMask] != -1) return dp[pos][productMask];


        // case 1: skip current pos
        int ans = dfs(pos + 1, productMask, numsPrimeMask, dp);

        // case 2: select current if not conflict
        if ((productMask & numsPrimeMask[pos]) == 0) {
            ans = (ans + dfs(pos + 1, productMask | numsPrimeMask[pos], numsPrimeMask, dp)) % MOD;
        }

        return dp[pos][productMask] = ans;
    }

    private int computeMask(int x, int[] primes) {
        int mask = 0;
        for (int i = 0; i < primes.length; i++) {
            int p = primes[i];
            int cnt = 0;
            while (x % p == 0) {
                x /= p;
                cnt++;
            }

            if (cnt == 0) continue;
            if (cnt == 1) mask |= (1 << (i + 1));
            if (cnt >= 2) return -1;
        }
        return mask;
    }
}