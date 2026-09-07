/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int maxSumBST(TreeNode root) {
        ans=0;
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root){
        if(root==null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left= dfs(root.left);
        int[] right= dfs(root.right);
        if(root.val > left[1] && root.val < right[0]){
            int curr= left[2]+right[2]+root.val;
            ans=Math.max(ans,curr);
            int minvalue= Math.min(root.val, left[0]);
            int maxvalue= Math.max(root.val, right[1]);
            return new int[]{minvalue, maxvalue, curr};
        }   
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE,0};
    }
}