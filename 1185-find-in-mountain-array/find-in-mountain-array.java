/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
    int n=mountainArr.length();
    int peakIndex=peakIndexMountainArray(mountainArr);
    int idx=binarySearch(mountainArr,0,peakIndex,target);
    if(idx==-1) return reversebinarySearch(mountainArr,peakIndex,n-1,target);
    return idx;    
    }

    //finding the peak index so that it mountain array gets divide in two parts so that we can apply the binary search in both the parts 
    private int peakIndexMountainArray(MountainArray mountainArr){
        int n=mountainArr.length();
        int l=0,r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)) l=mid+1;
            else r=mid;
        }
        return l;
    }

    //applying the binary search in the first half till the peak index and finding the index of the target
    private int binarySearch(MountainArray mountainArr, int l, int r, int target){
        int mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(mountainArr.get(mid)==target) return mid;
            else if(mountainArr.get(mid) > target) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    // applying the binary search in the next half till the end strating from the index+1 and returnning the index of the target element found
    private int reversebinarySearch(MountainArray mountainArr, int l, int r, int target){
        int mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(mountainArr.get(mid)==target) return mid;
            else if(mountainArr.get(mid) < target) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}