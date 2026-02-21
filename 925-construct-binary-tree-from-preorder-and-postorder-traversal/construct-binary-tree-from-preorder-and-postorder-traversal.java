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
    public TreeNode constructFromPrePost(int preorder[],int presi,int preei,int postorder[],int psi,int pei) {
        if(presi>preei) {
            return null;
        }
        if(presi==preei) {
            return new TreeNode(preorder[presi]);
        }
        TreeNode root=new TreeNode(preorder[presi]);
        int idx=psi;
        while(postorder[idx]!=preorder[presi+1]) {
            idx++;
        }
        int leftElements=idx-psi+1;
        root.left=constructFromPrePost(preorder,presi+1,presi+leftElements,postorder,psi,psi+leftElements-1);
        root.right=constructFromPrePost(preorder,presi+leftElements+1,preei,postorder,psi+leftElements,pei);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        return constructFromPrePost(preorder,0,n-1,postorder,0,n-1);
    }
}