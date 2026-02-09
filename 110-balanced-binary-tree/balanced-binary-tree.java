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
    class Pair {
        int height;
        boolean isBalanced;
        public Pair() {}
        public Pair(int height,boolean isBalanced) {
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }
    public Pair isBalanced1(TreeNode root) {
        if(root==null) {
            return new Pair(-1,true);
        }
        Pair left=isBalanced1(root.left);
        Pair right=isBalanced1(root.right);
        if(left.isBalanced==false || right.isBalanced==false||left.height-right.height>1 || left.height-right.height<-1) {
          return new Pair(0,false);
        }
        Pair ansPair=new Pair();
        ansPair.height=Math.max(left.height,right.height)+1;
        ansPair.isBalanced=true;
        return ansPair;
    }
    public boolean isBalanced(TreeNode root) {
       return isBalanced1(root).isBalanced;
    }
}