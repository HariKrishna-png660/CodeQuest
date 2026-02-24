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
    public void getAllRootToLeafPaths(TreeNode root,ArrayList<String> paths,String psf) {
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null) {
            paths.add(psf+root.val+"");
            return;
        }
        getAllRootToLeafPaths(root.left,paths,psf+root.val+"");
        getAllRootToLeafPaths(root.right,paths,psf+root.val+"");
    }
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> paths=new ArrayList<>();
        getAllRootToLeafPaths(root,paths,"");
        int sum=0;
        for(String s:paths) {
            sum += Integer.parseInt(s,2);
        }
        return sum;
    }
}