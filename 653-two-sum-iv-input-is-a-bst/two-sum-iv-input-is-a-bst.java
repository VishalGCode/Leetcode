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
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return inorder(root, map, k);
    }

    private boolean inorder(TreeNode root, Map<Integer, Integer> map, int k) {
        if (root == null)
            return false;
        if (inorder(root.left, map, k))
            return true;
        int complement = k - root.val;
        if (map.containsKey(complement))
            return true;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        return inorder(root.right, map, k);
    }
}