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
    int postIdx;
    java.util.Map<Integer,Integer> inMap=new java.util.HashMap<>();

    public TreeNode buildTree(int[] inorder,int[] postorder){
        postIdx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return construct(postorder,0,inorder.length-1);
    }

    private TreeNode construct(int[] postorder,int start,int end){
        if(start>end)return null;
        int rootVal=postorder[postIdx--];
        TreeNode root=new TreeNode(rootVal);
        int mid=inMap.get(rootVal);
        root.right=construct(postorder,mid+1,end);
        root.left=construct(postorder,start,mid-1);
        return root;
    }
}