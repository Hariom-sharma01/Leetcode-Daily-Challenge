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
    public int index=0;
    public TreeNode recoverFromPreorder(String st) {
        TreeNode cur = recover(st, 0);
        return cur;
    }
    public TreeNode recover(String S, int depth) {
        if (index >= S.length()) return null;
        int curDepth = 0; int tmp = index;
        while (S.charAt(tmp) == '-') {
            tmp++; curDepth++;
        }
        if (curDepth <= depth && curDepth != 0) return null;
        index = tmp;
        int val = 0;
        while (index < S.length() && S.charAt(index) != '-') {
            val *= 10;
            val += S.charAt(index) - '0';
            index++;
        }
        TreeNode cur = new TreeNode(val);
        cur.left = recover(S, curDepth);
        cur.right = recover(S, curDepth);
        return cur;
    }
}