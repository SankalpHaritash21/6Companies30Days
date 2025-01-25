class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();

        if (n <= 45)
            helper(k, n, 1, combinations, new ArrayList<>());

        return combinations;
    }

    private void helper(int k, int n, int value, List<List<Integer>> combinations,
            List<Integer> combination) {
        int combinationSize = combination.size();

        if (combinationSize == k && n == 0) {
            combinations.add(new ArrayList<>(combination));
            
            return;
        }

        for (int i = value; i < 10; i++) {
            if (combinationSize > k || n < 0)
                break;

            combination.add(i);

            helper(k, n - i, i + 1, combinations, combination);

            combination.remove(combination.size() - 1);
        }
    }
}