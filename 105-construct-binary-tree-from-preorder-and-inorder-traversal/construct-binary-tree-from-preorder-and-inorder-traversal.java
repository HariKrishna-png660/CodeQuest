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
    public TreeNode buildTree(int preorder[],int psi,int pei,int inorder[],int isi,int iei) {
        if(psi>pei) {
            return null;
        }
        TreeNode root=new TreeNode(preorder[psi]);
        int leftElements=0;
        int rootIdx=isi;
        while(inorder[rootIdx]!=root.val) {
            rootIdx++;
            leftElements++;
        }
        root.left=buildTree(preorder,psi+1,psi+leftElements,inorder,isi,rootIdx-1);
        root.right=buildTree(preorder,psi+leftElements+1,pei,inorder,rootIdx+1,iei);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return buildTree(preorder,0,n-1,inorder,0,n-1);
    }
}