class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        int index = s.indexOf(a);
        while (index != -1) {
            aList.add(index);
            index = s.indexOf(a, index + 1);
        }
        index = s.indexOf(b);
        while (index != -1) {
            bList.add(index);
            index = s.indexOf(b, index + 1);
        }
        List<Integer> ans = new ArrayList<>();
        if (aList.isEmpty() || bList.isEmpty()) {
            return ans;
        }
        for (int i : aList) {
            if (nearby(i, bList, k)) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean nearby(int val, List<Integer> list, int diff) {
        int low = 0, high = list.size() - 1;
        if (val < list.get(low) - diff || val > list.get(high) + diff) {
            return false;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int temp = list.get(mid);
            if (Math.abs(temp - val) <= diff) {
                return true;
            }
            if (temp > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return false;
    }

}