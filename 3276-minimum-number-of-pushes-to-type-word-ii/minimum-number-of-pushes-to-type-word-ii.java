class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int[] freq= new int[26];
        for(int i=0;i<n;i++){
            freq[word.charAt(i)-'a']++; 
        }  
        int ans = 0;
        int count = 0;
        Arrays.sort(freq);
        int j = 0;
        while(freq[j] == 0){
            j++;
        }
        for(int i = 25; i >= j; i--){
            if(25-i < 8) ans += freq[i];
            else if(25-i < 16) ans += 2 * freq[i];
            else if(25-i < 24) ans += 3 * freq[i];
            else ans += 4 * freq[i];
        }
        return ans;
    }
}