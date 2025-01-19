class Solution {
    // calculate Z array
public int[] calculateZ(char[] input) {
	int[] Z = new int[input.length];
	int left = 0, right = 0;
	for (int i = 1; i < input.length; i++) {
		if (i > right) {
			left = right = i;
			while (right < input.length && input[right] == input[right - left]) {
				right++;
			}
			Z[i] = right - left;
			right--;
		} else {
			int k = i - left;
			if (Z[k] < right - i + 1) {
				Z[i] = Z[k];
			} else {
				left = i;
				while (right < input.length && input[right] == input[right - left]) {
					right++;
				}
				Z[i] = right - left;
				right--;
			}
		}
	}
	return Z;
}

public long sumScores(String s) {
	int[] z = calculateZ(s.toCharArray());

	long sum = 0;
	for(int el: z)
		sum += el;
	sum += s.length();
	return sum;
}
}