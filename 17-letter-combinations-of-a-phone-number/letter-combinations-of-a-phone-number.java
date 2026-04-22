class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keypad= {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans=new ArrayList<>();
        backtrack("", digits, keypad, ans);
        return ans; 
    }
    private void backtrack(String combination, String nextdig, String[] keypad, List<String> ans){
        if(nextdig.isEmpty()) ans.add(combination);
        else{
            String letters=keypad[nextdig.charAt(0)-'2'];
            for(char letter : letters.toCharArray()){
                backtrack(combination+letter, nextdig.substring(1), keypad, ans);
            }
        }
    }
}