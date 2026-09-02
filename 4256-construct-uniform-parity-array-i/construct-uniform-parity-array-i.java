class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = -1;
        for(int x:nums1){
            if(x%2 != 0){
                odd=x;
                break;
            }
        }
        int[] nums2=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            if(nums1[i] %2 == 0){
                if(odd != -1) nums2[i] = nums1[i]-odd;
                else nums2[i]=nums1[i]-odd;
            }else nums2[i]=nums1[i];
        }
        int target=Math.abs(nums2[0]%2);
        for(int x:nums2){
            if(Math.abs(x%2) != target) return false;
        }
        return true;
    }
}