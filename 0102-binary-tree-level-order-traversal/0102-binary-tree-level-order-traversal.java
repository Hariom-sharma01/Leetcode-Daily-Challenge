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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> ls=new ArrayList<>();
            int len=q.size();
            
            for(int i=0;i<len;i++){
                TreeNode nn=q.poll();
                ls.add(nn.val);
                if(nn.left!=null)
                q.add(nn.left);
                if(nn.right!=null)
                q.add(nn.right);
            }
            ans.add(ls);

        }
        return ans;
    }
}