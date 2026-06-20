class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
    HashMap<String, Integer> map = new HashMap<>();
    int n = senders.length;
    for(int i=0;i<n;i++){
        int sp=0;
        for(int j=0; j<messages[i].length(); j++){
            if(messages[i].charAt(j) == ' ') sp++;
        }
        map.put(senders[i],
        map.getOrDefault(senders[i], 0) + sp + 1);
    }    
        int mx=0;
        String ans = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int curr = entry.getValue();
            String sender = entry.getKey();
            if(curr>mx || (curr == mx && sender.compareTo(ans) > 0)){
                mx=curr;
                ans=sender;
            }
        }
        return ans;
    }
} 