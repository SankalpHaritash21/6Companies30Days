
// only two states 

//1)  already purchased stock and less than two 
     // a) notSell
     // b) sell
     // send signal as transaction true
     // send count 

//2)  not purchased 
      // a) buy
      // b) notBuy 

           


class Solution {
    Map<String, Integer> mem = new HashMap<>();
    public int maxProfit(int k ,int[] prices) {
        return recur(k, prices, 0, false, 0 );
    }
    private int recur(int k, int[] prices, int i, boolean hasStock, int count) {
        String s = i + ":" + hasStock + ":" + count;
        
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        
        
        int res = 0;
        if(i >= prices.length || count>=k)
        {
            return res;
        }      
      
        if (hasStock) {
            int sell =  prices[i] + recur(k, prices, i+1, false, count+1) ;
            int notSell = recur(k, prices, i+1, true, count);
            res = Math.max(sell, notSell);
        } else {
            int buy = recur(k, prices, i+1, true, count) - prices[i];
            
            int notBuy = recur(k, prices, i+1, false, count);
            res = Math.max(res, Math.max(buy, notBuy));
        }
        mem.put(s, res);
        return res;
    }
}

