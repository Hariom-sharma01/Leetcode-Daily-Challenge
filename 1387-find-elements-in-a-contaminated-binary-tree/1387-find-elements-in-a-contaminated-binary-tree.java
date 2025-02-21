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
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
    }
    
    public boolean find(int t) {
        return fun(t)!=null;
    }
    public TreeNode fun(int t){
        if (t == 0)
            return this.root;
        int par = (t - 1) / 2, rem = t % 2;
        TreeNode res =fun(par);
        if (res == null)
            return null;
        if (rem == 1)
            return res.left;
        else
            return res.right;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */