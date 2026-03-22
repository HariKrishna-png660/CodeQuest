class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int j=y;j<(y+k);j++) {
            for(int i=(x+k)-1;i>=x;i--) {
                list.add(grid[i][j]);
            }
        }
        int index=0;
        for(int j=y;j<(y+k);j++) {
            for(int i=x;i<(x+k);i++) {
                grid[i][j]=list.get(index++);
            }
        }
        return grid;
    }
}