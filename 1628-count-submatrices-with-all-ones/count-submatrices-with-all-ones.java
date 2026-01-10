class Solution {
    public int numSubmat(int[][] mat) {
         int n=mat.length;
         int m=mat[0].length;
         int heightSoFar[]=new int[m];
         int count=0;

         for(int i=0;i<n;i++) {
             for(int j=0;j<m;j++) {
                if(mat[i][j]==0) {
                    heightSoFar[j]=0;
                    continue;
                }
                else {
                    heightSoFar[j]++;
                }
                int minHeight=n;
                for(int k=j;k>=0;k--) {
                    minHeight=Math.min(minHeight,heightSoFar[k]);
                    count += minHeight;
                }
             }
         }
         return count;
    }
}