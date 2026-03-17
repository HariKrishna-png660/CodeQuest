class Solution {
    public void generateParenthesis(String curr,int open,int close,int n,List<String> ans) {
         if(curr.length()== 2*n) {
            ans.add(curr);
            return;
         }
         if(open<n) {
             generateParenthesis(curr+"(",open+1,close,n,ans);
         }
         if(close<open) {
            generateParenthesis(curr+")",open,close+1,n,ans);
         }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generateParenthesis("",0,0,n,ans);
        return ans;
    }
}