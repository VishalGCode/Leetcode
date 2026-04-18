class Solution {
    int currVal = 0;
    int currCount = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        process(node.val);
        inorder(node.right);
    }

    private void process(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            result.clear();
            result.add(val);
        } else if (currCount == maxCount) {
            result.add(val);
        }
    }
}