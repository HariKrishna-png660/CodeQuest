class Solution {
    public void transposeMatrix(int grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                int temp=grid[i][j];
                grid[i][j]=grid[j][i];
                grid[j][i]=temp;
            }
        }
    }
    public void reverseEveryRow(int arr[]) {
        int si=0;
        int ei=arr.length-1;
        while(si<ei) {
            int elementAtsi=arr[si];
            int elementAtei=arr[ei];
            arr[si]=elementAtei;
            arr[ei]=elementAtsi;
            si++;
            ei--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        transposeMatrix(matrix);
        for(int i=0;i<n;i++) {
            reverseEveryRow(matrix[i]);
        }
    }
}