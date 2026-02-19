/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // node to root path 
    public ArrayList<TreeNode> nodeToRootPath(TreeNode root,TreeNode target) {
        if(root==null) {
            return new ArrayList<>();
        }
        if(root.equals(target)) {
            ArrayList<TreeNode> baseAns=new ArrayList<>();
            baseAns.add(target);
            return baseAns;
        }
        ArrayList<TreeNode> left=nodeToRootPath(root.left,target);
        if(left.size()>0) {
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right=nodeToRootPath(root.right,target);
        if(right.size()>0) {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
    public void getNodesAtKlevelDown(TreeNode root,int k,ArrayList<Integer> ans,TreeNode blocker) {
         if(root==null || root.equals(blocker)) {
             return;
         }
         if(k==0) {
            ans.add(root.val);
            return;
         }
         getNodesAtKlevelDown(root.left,k-1,ans,blocker);
         getNodesAtKlevelDown(root.right,k-1,ans,blocker);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         ArrayList<TreeNode> ntrPath=nodeToRootPath(root,target);
         ArrayList<Integer> ans=new ArrayList<>();
         for(int i=0;i<ntrPath.size();i++) {
             TreeNode blocker= i==0? null:ntrPath.get(i-1);
             getNodesAtKlevelDown(ntrPath.get(i),k-i,ans,blocker);
         }
         return ans;
    }
}