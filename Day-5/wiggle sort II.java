class Solution {
    public void wiggleSort(int[] nums) {
        int n= nums.length-1;

        int[] ans= Arrays.copyOf(nums, nums.length);

        Arrays.sort(ans);

        for(int i=1;i<nums.length;i+=2)
            nums[i]=ans[n--];
        //even position
        for(int i=0;i<nums.length;i+=2)
            nums[i]=ans[n--];
    }
}