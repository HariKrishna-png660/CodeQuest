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
    // approach 1
    // time complexity is O(n)
    // public int countNodes(TreeNode root) {
    //     if(root==null) {
    //         return 0;
    //     }
    //     int nodesInLeftSubTree=countNodes(root.left);
    //     int nodesInRightSubTree=countNodes(root.right);
    //     return nodesInLeftSubTree+nodesInRightSubTree+1;
    // }
    // approach 2
    // time complexity is O(logn)^2
    public int leftHeight(TreeNode root) {
        int height=0;
        while(root!=null) {
            height++;
            root=root.left;
        }
        return height;
    }
    public int rightHeight(TreeNode root) {
        int height=0;
        while(root!=null) {
            height++;
            root=root.right;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int lh=leftHeight(root);
        int rh=rightHeight(root);
        if(lh==rh) {
            return (int)(Math.pow(2,lh)-1);
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}