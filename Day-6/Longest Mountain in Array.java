class Solution {
    public int longestMountain(int[] arr) {
        int n= arr.length, r=0;

        int[] up=new int[n], d=new int[n];

        for(int i=n-2;i>=0;i--){
            if(arr[i]> arr[i+1])
            d[i]= d[i+1]+1;
        }

        for(int i=0;i<n;i++){
            if(i>0 && arr[i]>arr[i-1]){
                up[i]= up[i-1]+1;
            }
            if(up[i]>0 && d[i]>0){
                r=Math.max(r, up[i]+d[i]+1);
            }
        }

        return r;
    }
}