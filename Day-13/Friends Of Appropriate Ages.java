class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> c=new HashMap<>();

        for(int a: ages){
            c.put(a, c.getOrDefault(a, 0)+1);
        }

        int r=0;
        for(Integer a: c.keySet()){
            for(Integer b: c.keySet()){
                if(request(a,b))
                r+= c.get(a) * (c.get(b) - (a == b ? 1 :0));
            }
        }

        return r;
    }

     private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
}