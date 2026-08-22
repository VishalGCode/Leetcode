class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,int[][] friends,int id,int level) {
        int n=friends.length;
        boolean[] visited=new boolean[n];
        java.util.Queue<Integer> queue=new java.util.LinkedList<>();
        
        queue.offer(id);
        visited[id]=true;
        
        int currentLevel=0;
        while(!queue.isEmpty()&&currentLevel<level){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                for(int friend:friends[curr]){
                    if(!visited[friend]){
                        visited[friend]=true;
                        queue.offer(friend);
                    }
                }
            }
            currentLevel++;
        }
        
        java.util.Map<String,Integer> freqMap=new java.util.HashMap<>();
        while(!queue.isEmpty()){
            int friendId=queue.poll();
            for(String video:watchedVideos.get(friendId)){
                freqMap.put(video,freqMap.getOrDefault(video,0)+1);
            }
        }
        
        List<String> result=new java.util.ArrayList<>(freqMap.keySet());
        result.sort((a,b)->{
            int freqA=freqMap.get(a);
            int freqB=freqMap.get(b);
            if(freqA!=freqB){
                return Integer.compare(freqA,freqB);
            }
            return a.compareTo(b);
        });
        
        return result;
    }
}