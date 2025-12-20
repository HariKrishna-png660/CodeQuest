class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        char grid[][]=new char[n][m];
        for(int i=0;i<n;i++) {
            String curr=strs[i];
            for(int j=0;j<m;j++) {
                char ch=curr.charAt(j);
                grid[i][j]=ch;
            }
        }
        int count=0;
       for(int j=0;j<m;j++) {
          for(int i=0;i<n-1;i++) {
              char curr=grid[i][j];
              char next=grid[i+1][j];
              if(curr>next) {
                 count++;
                 break;
              }
          }
       }
       return count;
    }
}