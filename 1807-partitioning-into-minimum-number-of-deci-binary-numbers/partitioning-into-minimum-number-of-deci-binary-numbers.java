class Solution {
    public int minPartitions(String n) {
    int count=0;
    for(char c: n.toCharArray()) count=Math.max(count, c-'0');
    return count;       
    }
}