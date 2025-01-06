class Solution {
    static String str = "";
    static char name = 'A';

    static String matrixChainOrder(int arr[]) {
        int n = arr.length;
        str = "";
        name = 'A';
        int[][] dp = new int[n][n];
        int[][] bracket = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        solve(arr, 1, n - 1, dp, bracket);
        printOptimalParenthesis(1, n - 1, bracket);
        return str;
    }

    public static void printOptimalParenthesis(int i, int j, int[][] memoization) {
        if (i == j) {
            str = str + name;
            name++;
        } else {
            int k = memoization[i][j];
            str = str + "(";
            printOptimalParenthesis(i, k, memoization);
            printOptimalParenthesis(k + 1, j, memoization);
            str = str + ")";
        }
    }

    static int solve(int[] arr, int i, int j, int[][] dp, int[][] bracket) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(arr, i, k, dp, bracket) +
                       solve(arr, k + 1, j, dp, bracket) + arr[i - 1] * arr[k] * arr[j];
            if (min > temp) {
                min = Math.min(min, temp);
                dp[i][j] = min;
                bracket[i][j] = k;
            }
        }
        return min;
    }
}