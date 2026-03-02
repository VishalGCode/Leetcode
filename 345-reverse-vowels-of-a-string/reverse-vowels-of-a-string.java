class Solution {
    public String reverseVowels(String s) {
        char str[]=s.toCharArray();
        int left=0,right=str.length-1;
        while(left<right){
            while(left<right && !isVowel(str[left])) left++;
            while(left<right && !isVowel(str[right])) right--;
            if(left<right){
                char temp=str[left];
                str[left]=str[right];
                str[right]=temp;
                left++;
                right--;
            }
        }
        return new String(str);
    }
    static boolean isVowel(char ch){
        String vowels="AEIOUaeiou";
        return vowels.indexOf(ch)!=-1;
    }
}