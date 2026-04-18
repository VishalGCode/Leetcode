class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return inorder(root, set, k);
    }

    private boolean inorder(TreeNode root, Set<Integer> set, int k) {
        if (root == null)
            return false;
        if (inorder(root.left, set, k))
            return true;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return inorder(root.right, set, k);
    }
}