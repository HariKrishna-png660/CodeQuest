class Solution {
    public int numSpecial(int[][] mat) {
        // precompute the number of ones in each of the row and coloumn 
        int n=mat.length;
        int m=mat[0].length;
        int rows[]=new int[n];
        int cols[]=new int[m];
        for(int i=0;i<n;i++) {
            int count=0;
           for(int j=0;j<m;j++) {
               if(mat[i][j]==1) {
                  count++;
               }
           }
           rows[i]=count;
        //    System.out.print(count);
        }
        
        for(int j=0;j<m;j++) {
            int count=0;
            for(int i=0;i<n;i++) {
                 if(mat[i][j]==1) {
                    count++;
                 }
            }
            cols[j]=count;
            // System.out.print(count);
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j]>1) {
                    break;
                }
                if(mat[i][j]==1 && rows[i]==1 && cols[j]==1) {
                    ans++;
                } 
            }
        }
        return ans;
    }
}