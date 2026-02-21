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
    public ArrayList<TreeNode> nodeToRootPath(TreeNode root,TreeNode node) {
        if(root==null) {
            return new ArrayList<>();
        }
        if(root.equals(node)) {
            ArrayList<TreeNode> baseAns=new ArrayList<>();
            baseAns.add(root);
            return baseAns;
        }
        ArrayList<TreeNode> left=nodeToRootPath(root.left,node);
        if(!left.isEmpty()) {
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right=nodeToRootPath(root.right,node);
        if(!right.isEmpty()) {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ntr1=nodeToRootPath(root,p);
        ArrayList<TreeNode> ntr2=nodeToRootPath(root,q);
        int i=ntr1.size()-1;
        int j=ntr2.size()-1;
        TreeNode lca=root;
        while(i>=0 && j>=0) {
            if(ntr1.get(i).equals(ntr2.get(j))) {
               lca=ntr1.get(i);
            }
            i--;
            j--;
        }
        return lca;
    }
}