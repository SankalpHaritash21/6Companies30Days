class Solution {
    public int waysToSplitArray(int[] nums) {
        long LSum=0, RSum=0;

        for(int i: nums){
            RSum += i;
        }

        int ValidSplit= 0;

        for(int i=0; i<nums.length-1;i++){
            LSum += nums[i];
            RSum -= nums[i];

            if( LSum>= RSum){
                ValidSplit++;
            }
        }

        return ValidSplit;
    }
}