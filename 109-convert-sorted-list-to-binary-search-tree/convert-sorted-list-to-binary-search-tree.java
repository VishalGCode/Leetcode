class Solution {
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head){
        int size = getSize(head);
        current = head;
        return buildTree(0, size - 1);
    }

    private int getSize(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    private TreeNode buildTree(int left, int right){
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode leftNode = buildTree(left, mid - 1);
        TreeNode root = new TreeNode(current.val);
        root.left = leftNode;
        current = current.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}