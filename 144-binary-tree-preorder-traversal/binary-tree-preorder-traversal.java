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
        TreeNode node;
        int state;
        public Pair(TreeNode node,int state) {
            this.node=node;
            this.state=state;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<Pair> st=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root!=null) {
            st.add(new Pair(root,1));
        }
        while(st.size()>0) {
            if(st.peek().state==1) {
                ans.add(st.peek().node.val);
                st.peek().state++;
                if(st.peek().node.left!=null) {
                     st.push(new Pair(st.peek().node.left,1));
                }
            }
            else if(st.peek().state==2) {
                st.peek().state++;
                if(st.peek().node.right!=null) {
                     st.push(new Pair(st.peek().node.right,1));
                }
            }
            else {
                st.pop();
            }
        }
        return ans;
    }
}