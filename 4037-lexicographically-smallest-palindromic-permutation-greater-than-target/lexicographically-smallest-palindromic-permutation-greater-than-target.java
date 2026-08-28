class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();
        int[] count=new int[26];
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
        }    
        int odd=0, mid=-1;
        for(int i=0;i<26;i++){
            if(count[i]%2 != 0){
                odd++;
                mid=i;
            }
        }
        if(odd>1) return "";
        int[] half=new int[26];
        for(int i=0;i<26;i++){
            half[i]=count[i]/2;
        }
        int halflen=n/2;
        int[] available=half.clone();
        int maxprefix=0;
        while(maxprefix < halflen){
            int ch=target.charAt(maxprefix)-'a';
            if(available[ch] > 0){
                available[ch]--;
                maxprefix++;
            }else break;
        }
        for(int p=maxprefix; p>=0; p--){
            int startchar;
            if(p<halflen) startchar=target.charAt(p)-'a'+1;
            else startchar=0;
            for(int c=startchar; c<26; c++){
                if(p<halflen && available[c] == 0) continue;
                char[] candidate= new char[n];
                for(int i=0;i<p;i++){
                    candidate[i]=target.charAt(i);
                }
                int[] temp=available.clone();
                if(p<halflen){
                    candidate[p]=(char)('a'+c);
                    temp[c]--;
                }
                int idx=(p<halflen)?p+1:p;
                for(int ch=0;ch<26;ch++){
                    while(temp[ch]>0){
                        candidate[idx++] = (char) ('a' + ch);
                        temp[ch]--;
                    }
                }
                if(n%2 != 0){
                    candidate[halflen] = (char)('a'+mid);
                }
                for(int i=0;i<halflen;i++){
                    candidate[n-1-i]=candidate[i];
                }
                String res=new String(candidate);
                if(res.compareTo(target) > 0) return res;
            }
            if(p>0) available[target.charAt(p-1)-'a']++;
        }
        return "";
    }
}