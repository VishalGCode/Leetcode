// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int count=0;
//         for(int i=0; i<nums.length-2; i++){
//             if((nums[i] < nums[i+1]) && (nums[i+1] < nums[i+2])){
//                 count++;
//                 continue;
//             }
//         }    
//         if(count>0) return true;
//         return false;
//     }
// }


class Solution {
    public boolean increasingTriplet(int[] nums) {
       int min1 = Integer.MAX_VALUE;
       int min2 = Integer.MAX_VALUE;
       for(int n : nums) {
           if(n <= min1) min1 = n;
           else if(n <= min2) min2 = n;
           else return true;
       }
       return false;
    }
}