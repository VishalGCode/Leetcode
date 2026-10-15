class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && maxHeights.get(stk.peek()) >= maxHeights.get(i)){
                stk.pop();
            }
            if(stk.isEmpty()){
                left[i]=(long)(i+1)*maxHeights.get(i);
            }else{
                int p=stk.peek();
                left[i]=left[p] + (long)(i-p)*maxHeights.get(i);
            }
            stk.push(i);
        }
        stk.clear();
        long maxSum=0;
        for (int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && maxHeights.get(stk.peek()) >= maxHeights.get(i)){
                stk.pop();
            }
            if(stk.isEmpty()){
                right[i] = (long)(n-i)*maxHeights.get(i);
            }else{
                int p=stk.peek();
                right[i]=right[p]+(long)(p-i)*maxHeights.get(i);
            }
            stk.push(i);
            long totalSum=left[i]+right[i]-maxHeights.get(i);
            maxSum = Math.max(maxSum, totalSum);
        }
        return maxSum;
    }
}
