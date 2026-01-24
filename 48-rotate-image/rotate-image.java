class Solution {
    public void swap(int i,int j,int matrix[][]) {
        int valueAtIJ=matrix[i][j];
        int valueAtJI=matrix[j][i];
        matrix[i][j]=valueAtJI;
        matrix[j][i]=valueAtIJ;
    }
    public void reverseRow(int arr[]) {
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j) {
            int valueAtI=arr[i];
            int valueAtJ=arr[j];
            arr[i]=valueAtJ;
            arr[j]=valueAtI;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        // transpose karo given matrix 
        // then reverse every row in the matrix
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                 if(j<i) {
                    swap(i,j,matrix);
                 }
            }
        }
        // reverse every row 
        for(int i=0;i<m;i++) {
            reverseRow(matrix[i]);
        }
    }
}