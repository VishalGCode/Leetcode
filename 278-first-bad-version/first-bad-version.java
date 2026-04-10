/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return f1(1,n);    
    }
    private int f1(int low, int high){
        if(high-low+1==1) return low;
        int mid=low+(high-low)/2;
        if(isBadVersion(mid)) return f1(low,mid);
        else return f1(mid+1,high);
    }
}