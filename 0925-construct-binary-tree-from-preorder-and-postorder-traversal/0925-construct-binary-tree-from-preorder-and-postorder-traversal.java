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
    int postPreInd = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < postorder.length - 1; i++) {
            map.put(postorder[i], i);
        }
        return constructTree(preorder, map, 0, postorder.length - 1);
    }
     public TreeNode constructTree(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[postPreInd++]);
        if(start == end) {
            return root;
        }
        int index = map.get(preorder[postPreInd]);
        root.left = constructTree(preorder, map, start, index);
        root.right = constructTree(preorder, map, index + 1, end - 1);
        return root;
    }
}