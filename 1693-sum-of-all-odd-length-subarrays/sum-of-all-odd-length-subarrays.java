class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length, count=0;
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=i;j<n;j++){
                // int curr=0;
                curr+=arr[j];
                if((j-i+1)%2!=0) count+=curr;
            }
        }
        return count;
    }
}