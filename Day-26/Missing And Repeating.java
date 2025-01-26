class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        long n = arr.length;
        
        long expectedSoln = (long) (n * (n+1)) / 2;
        long expectedSqrSoln = (long) (n * (n+1) * (2*n+1)) / 6;
        
        long actualSoln = 0, actualSqrSoln = 0;
        for(int i=0; i<n; i++) {
            actualSoln += arr[i];
            actualSqrSoln += (long) arr[i] * arr[i];
        }
        
        long x = actualSoln - expectedSoln;
        long y = (actualSqrSoln - expectedSqrSoln) / x;
        
        long X = (x+y) / 2;
        long Y = X - x;
        
        ans.add((int) X);
        ans.add((int) Y);
        
        return ans;
    }
}