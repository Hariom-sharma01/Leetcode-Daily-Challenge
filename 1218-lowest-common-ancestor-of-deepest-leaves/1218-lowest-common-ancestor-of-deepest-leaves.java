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
    private TreeNode lca;  
    private int maxDepth;  

    public TreeNode lcaDeepestLeaves(TreeNode root) {  
        lca = null;  
        maxDepth = -1;  
        depth(root, 0);  
        return lca;  
    }  

    private int depth(TreeNode node, int depth) {  
        if (node == null) {  
            return depth;  
        }  

        int ld = depth(node.left, depth + 1);  
        int rd = depth(node.right, depth + 1);  

        if (ld == rd) {  
            if (ld >= maxDepth) {  
                maxDepth = ld;  
                lca = node;  
            }  
            return ld;  
        } else if (ld > rd) {  
            return ld;  
        } else {  
            return rd;  
        }  
    }  
}  