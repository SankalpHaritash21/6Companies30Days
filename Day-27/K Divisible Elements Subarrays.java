import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MAX_P = 200;

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        List<int[]> child = new ArrayList<>();
        child.add(new int[MAX_P + 1]);
        int nxt = 1, ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0, node = 0;
            int j = i;
            while (j < n && count <= k) {
                int c = nums[j++];
                if (c % p == 0) if (count++ == k) break;
                if (child.get(node)[c] == 0) {
                    ans++;
                    child.get(node)[c] = nxt++;
                    child.add(new int[MAX_P + 1]);
                }
                node = child.get(node)[c];
            }
        }
        return ans;
    }
}