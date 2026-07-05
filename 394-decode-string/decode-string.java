class Solution {
    int i=0;
    public String decodeString(String s) {
        //i=0;
        return decode(s);    
    }
    public String decode(String s){
        StringBuilder sb = new StringBuilder();
        int num=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
                i++;
            }else if(c == '[') {
                i++;
                String inner = decode(s);
                for(int k=0;k<num;k++) sb.append(inner);
                num=0;
            }else if(c==']'){
                i++;
                return sb.toString();
            }else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}