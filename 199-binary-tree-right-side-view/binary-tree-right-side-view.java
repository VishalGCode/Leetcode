class Solution{
    public void bfs(TreeNode root, List<Integer> ans){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int len = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(currLevel.get(currLevel.size() - 1));
        }
    }
    public List<Integer> rightSideView(TreeNode root){
        if (root==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        bfs(root,ans);
        return ans;
    }
}