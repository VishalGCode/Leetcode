class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int[] freq= new int[26];
        for(int i=0;i<n;i++){
            freq[word.charAt(i)-'a']++; 
        }  
        // int ans = 0;
        int count = 0;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            // int count1=(25-i)/8+1;
            count+=freq[i]*((25-i)/8+1);
        }
        return count;
    }
}