class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean ok = true;
                int lst = -1;

                for (int k = 0; k < n; k++) {
                    if (k >= i && k <= j) {
                        continue;
                    } else {
                        ok &= (lst < nums[k]);
                        lst = nums[k];
                    }
                }

                ans += ok ? 1 : 0;
            }
        }
        return ans;
    }
}

