class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recurse(result,0,0,"",n);
        return result;
    }
    public void recurse(List<String> result, int left, int right, String s, int n){
        if(s.length()==n*2){
            result.add(s);
            return;
        }
        if(left<n) recurse(result, left+1, right, s+"(",n);
        if(right<left) recurse(result, left, right+1, s+")",n);
    }
}