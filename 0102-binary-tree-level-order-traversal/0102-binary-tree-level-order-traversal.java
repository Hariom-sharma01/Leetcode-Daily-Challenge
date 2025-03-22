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
        if(root == null) return new ArrayList<>();

        List <List<Integer>> a1 = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        int l=0;
        while(!q.isEmpty()){
            ArrayList<Integer> ls=new ArrayList<>();
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode nn=q.poll();
                if(nn.left!=null)q.add(nn.left);
                if(nn.right!=null)q.add(nn.right);
                ls.add(nn.val);
            }
            a1.add(ls);
            l++;
        }
        return a1;
       
    }
}