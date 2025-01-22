class Solution {
	private static final long MOD_LONG = (long) 1e9 + 7;

	private static int multiply(int x, long y) {
		return (int) (x * (y % MOD_LONG) % MOD_LONG);
	}

	private static int pow(long x, long exp) {
		x %= MOD_LONG;
		if (x == 0)
			return 0;
		int e = (int) (exp % (MOD_LONG - 1));
		long p = 1;
		while (e > 0) {
			if ((e & 1) != 0)
				p = (p * x) % MOD_LONG;
			x = (x * x) % MOD_LONG;
			e >>>= 1;
		}
		return (int) p;
	}

	public static int minNonZeroProduct(int p) {
		if (p == 1)
			return 1;
		long q = (1L << p) - 2;
		return multiply(pow(q, q >>> 1), q + 1);
	}
}