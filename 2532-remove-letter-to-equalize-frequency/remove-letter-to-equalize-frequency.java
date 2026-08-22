class Solution {
    public boolean equalFrequency(String word) {
        int[] counts=new int[26];
        for(char c:word.toCharArray()){
            counts[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(counts[i]==0)continue;
            counts[i]--;
            if(checkEqual(counts))return true;
            counts[i]++;
        }
        return false;
    }

    private boolean checkEqual(int[] counts){
        int targetFreq=0;
        for(int count:counts){
            if(count==0)continue;
            if(targetFreq==0){
                targetFreq=count;
            }else if(count!=targetFreq){
                return false;
            }
        }
        return true;
    }
}