class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        // we need four pointers sr er sc ec
        int sr=0;
        int er=n-1;
        int sc=0;
        int ec=m-1;
         while(sr<=er && sc<=ec) {
             // print the top wall
             for(int col=sc;col<=ec;col++) {
                 ans.add(matrix[sr][col]);
             }
             sr++;
             // print the right wall
             for(int row=sr;row<=er;row++) {
                ans.add(matrix[row][ec]);
             }
             ec--;
             // print the bottom wall
             if(sr<=er) {
                    for(int col=ec;col>=sc;col--) {
                    ans.add(matrix[er][col]);
                    }
             er--;
             }
            
             // print the left wall
             if(sc<=ec) {
                  for(int row=er;row>=sr;row--) {
                ans.add(matrix[row][sc]);
             }
             sc++;
             }
         }
         return ans;
    }
}