class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false); 
        BSTIterator right = new BSTIterator(root, true); 

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == k) return true;
            else if (sum < k) i = left.next();
            else j = right.next();
        }

        return false;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = reverse ? node.right : node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();

        if (!reverse) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }
}