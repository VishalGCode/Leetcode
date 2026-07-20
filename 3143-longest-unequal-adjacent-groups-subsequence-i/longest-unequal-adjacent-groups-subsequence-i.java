class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int lastGroup = groups[0];
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != lastGroup) {
                ans.add(words[i]);
                lastGroup = groups[i]; 
            }
        }  
        return ans;
    }
}