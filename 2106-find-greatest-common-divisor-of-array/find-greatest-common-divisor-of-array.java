class Solution {
    public int findGCD(int[] nums) {
        int minElem=nums[0], maxElem=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minElem) minElem=nums[i];
            else if(nums[i]>maxElem) maxElem=nums[i];
        }
        int num1=minElem, num2=maxElem;
        while(num1>0){
            int temp=num2 % num1;
            num2=num1;
            num1=temp;
        }
        return num2;
    }
}