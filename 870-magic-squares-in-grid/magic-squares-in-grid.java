class Solution {
    public boolean isMagicSquare(int grid[][],int row,int col) {
        int rowSum=0;
        int colSum=0;
        int diagSum1=grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
        int diagSum2=grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col];
        if(diagSum1!=diagSum2) {
            return false;
        }
        HashMap<Integer,Integer> map1=new HashMap<>();
        for(int i=row;i<row+3;i++) {
            int currRowSum=0;
            for(int j=col;j<col+3;j++) {
                map1.put(grid[i][j],map1.getOrDefault(grid[i][j],0)+1);
                if(grid[i][j]>9 || grid[i][j]==0) {
                    return false;
                }
                currRowSum += grid[i][j];
            }
            if(currRowSum!=diagSum1) {
                return false;
            }
        }
        if(map1.size()!=9) {
            return false;
        }
        for(int j=col;j<col+3;j++) {
            int currColSum=0;
            for(int i=row;i<row+3;i++) {
                 if(grid[i][j]>9 || grid[i][j]==0) {
                    return false;
                }
                 currColSum += grid[i][j]; 
            }
            if(diagSum1!=currColSum) {
                return false;
            }
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<=m-3;i++) {
            for(int j=0;j<=n-3;j++) {
                if(isMagicSquare(grid,i,j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}