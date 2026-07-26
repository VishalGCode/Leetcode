class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        int res[]=new int[queries.length];
        StringBuilder stb=new StringBuilder();
        for(String str:chunks) stb.append(str);
        Map<String,Integer> map=new HashMap<>();
        int n=stb.length();
        int i=0;
        while(i<n){
            if(!Character.isLowerCase(stb.charAt(i))){
                i++;
                continue;
            }
            int st=i;
            StringBuilder word=new StringBuilder();
            while(i<n){
                char ch=stb.charAt(i);
                if(Character.isLowerCase(ch)) word.append(ch);
                else if(ch=='-'&&i>0&&i<n-1&&Character.isLowerCase(stb.charAt(i-1))&&Character.isLowerCase(stb.charAt(i+1))) word.append(ch);
                else break;
                i++;
            }
            String str=word.toString();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(int j=0;j<queries.length;j++) res[j]=map.getOrDefault(queries[j],0);
        return res;
        }
    }