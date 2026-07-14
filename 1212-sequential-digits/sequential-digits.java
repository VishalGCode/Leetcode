class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<9; i++) solve(low, high, ans, i);
        Collections.sort(ans);
        return ans;
    }
    private void solve(int low, int high, List<Integer> ans, int i){
        int num=i;
        int nextdigit = i+1;
        while(num <= high && nextdigit <= 9){
            num = num*10+nextdigit;
            if(num>=low && num<=high){
                ans.add(num);
            }
            nextdigit++;
        }    
    }
}
