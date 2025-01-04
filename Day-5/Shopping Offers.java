class Solution {

    private int encodeState(List<Integer> states) {
        int encoded = 0;
        for (int i = 0; i < states.size(); i++) {
            encoded |= states.get(i) << (4 * i);
        }
        return encoded;
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<Integer, Integer> map) {
        int encodeState = encodeState(needs);
        if(map.containsKey(encodeState))    return map.get(encodeState); // use the already computed result
        int result = 0;
        for(int i = 0; i < needs.size(); i++) {
            result += needs.get(i) * price.get(i);
        }

        for(int i = 0; i < special.size(); i++) {
            boolean valid = true;
            List<Integer> newNeeds = new ArrayList<>();
            for(int j = 0; j < needs.size(); j++) {
                if(needs.get(j) < special.get(i).get(j)) {
                    valid = false;
                    break;
                }
                newNeeds.add(needs.get(j) - special.get(i).get(j));
            }
            if(valid) {
                result = Math.min(result, special.get(i).get(price.size()) + helper(price, special, newNeeds, map));
            }
        }
        map.put(encodeState, result);
        return result;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<Integer, Integer> map = new HashMap<>(); // for memoization
        return helper(price, special, needs, map);
    }
}