import java.util.*;

class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        int currVal = 0;
        int currCount = 0;
        int maxCount = 0;
        while (curr != null) {
            if (curr.left == null) {
                int val = curr.val;
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
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    int val = curr.val;
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
                    curr = curr.right;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}