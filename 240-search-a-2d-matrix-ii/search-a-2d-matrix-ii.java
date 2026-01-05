class Solution {
    // in this question we need cannot apply binary search as we  did in the search a 2 d matrix 1
    // because these rows continution will not form any sortedd array
    // so we need to find such a starting position so that we can go through one of the directions when we are comparing that with the target
    public boolean searchMatrix(int[][] matrix, int target) {
        // two such positions are 0,n-1 and m-1,0
        int m=matrix.length;
        int n=matrix[0].length;
        int row=0;
        int col=n-1;
        while(row>=0 && row<m && col>=0 && col<n) {
            if(matrix[row][col]==target) {
                return true;
            }
            else if(matrix[row][col]>target) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}