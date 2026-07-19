class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] seen = new boolean[26];
        for(int i=0;i<s.length();i++) cnt[s.charAt(i)-'a']++;
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            cnt[c-'a']--;
            if(seen[c-'a']) continue;
            while(!stk.isEmpty() && c<stk.peek() && cnt[stk.peek()-'a']>0){
                char remove=stk.pop();
                seen[remove-'a']=false;
            }
            stk.push(c);
            seen[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stk) sb.append(c);
        return sb.toString();
    }
}