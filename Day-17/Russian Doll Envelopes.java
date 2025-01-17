class Solution {
    public int binarySearch(int[] dp, int val){
        int lo=0,hi=dp.length-1,res=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(dp[mid]<val){
                res=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return res+1;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] LIS=new int[envelopes.length+1];
        Arrays.fill(LIS,Integer.MAX_VALUE);
        LIS[0]=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<envelopes.length;i++){
            int val=envelopes[i][1];
            int insertIndex=binarySearch(LIS,val);
            ans=Math.max(ans,insertIndex);
            if(LIS[insertIndex]>=val){
                LIS[insertIndex]=val;
            }
        }
        return ans;
    }
}