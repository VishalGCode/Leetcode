class Solution {
    public boolean check(int[] arr) {
        int len=arr.length, pivot=1;
        while(pivot < len){
            if(arr[pivot] < arr[pivot - 1]) break;
            pivot++;
        }        
        for(int pos = pivot; pos < len; pos++){
            if(arr[0] < arr[pos]) return false;
            if (pos + 1 < len && arr[pos + 1] < arr[pos]) {
                return false;
            }
        }
        return true;
    }
}
       