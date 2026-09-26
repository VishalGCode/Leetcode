class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> pair : knowledge) map.put(pair.get(0), pair.get(1));
        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean br = false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                br=true;
                key.setLength(0);
            }else if(c==')'){
                br=false;
                String k =key.toString();
                res.append(map.getOrDefault(k,"?"));
            }else{
                if(br) key.append(c);
                else res.append(c);
            }
        }    
        return res.toString();
    }
}