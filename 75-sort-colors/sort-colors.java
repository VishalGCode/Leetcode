class Solution {
    public void sortColors(int[] nums) {
        int count1=0, count2=0, count3=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count1++;
            else if(nums[i]==1) count2++;
            else count3++;
        }
        for(int i=0;i<nums.length;i++){
            if(i<count1) nums[i]=0;
        }
        for(int i=0;i<nums.length;i++){
            if(i<count2) nums[count1+i]=1;
        }
        for(int i=0;i<nums.length;i++){
            if(i<count3) nums[count1+count2+i]=2;
        }
    }
}