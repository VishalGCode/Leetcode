class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        // int n = arr.length;
        int x = 1;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] > x) x += 1;
        }        
        return x;    
    }
}