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
    public int binaryToDecimal(String s) {
        int n=s.length();
        int num=0;
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch=='1') {
               num += (int) Math.pow(2,n-1-i);
            }
        }
        return num;
    }
    public ArrayList<String> getAllRootToLeafPaths(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        if(root.left==null && root.right==null) {
            ArrayList<String> baseAns=new ArrayList<>();
            baseAns.add(root.val+"");
            return baseAns;
        }
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> left=getAllRootToLeafPaths(root.left);
        for(String s:left) {
            StringBuilder sb=new StringBuilder(s);
            sb.insert(0,root.val+"");
            myAns.add(sb.toString());
        }
        ArrayList<String> right=getAllRootToLeafPaths(root.right);
        for(String s:right) {
             StringBuilder sb=new StringBuilder(s);
            sb.insert(0,root.val+"");
            myAns.add(sb.toString());
        }
        return myAns;
    }
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> paths=getAllRootToLeafPaths(root);
        // System.out.println(paths);
        int sum=0;
        for(int i=0;i<paths.size();i++) {
            int decimal=binaryToDecimal(paths.get(i));
            sum += decimal;
        }
        return sum;
    }
}