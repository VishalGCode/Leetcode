class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int i=0;
        int right=nums.length-1;
        while(i<=right){
            if(nums[i]==0){
                int temp=nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                i++;
                left++;
            }   
            else if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                // i++;
                right--;
            }else i++;            
        }
    }
}