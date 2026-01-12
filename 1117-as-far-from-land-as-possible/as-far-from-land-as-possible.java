class Solution {
    public int maxDistance(int[][] grid) {
         int n=grid.length;
         int m=grid[0].length;
         LinkedList<Integer> queue=new LinkedList<>();
         for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    queue.addLast(i*m+j);
                }
            }
         }
         if(queue.size()==0 || queue.size()==n*m) {
            return -1;
         }
         int dirs[][]={{-1,0},{0,1},{1,0},{0,-1}};
         int level=0;
         while(queue.size()>0) {
            int size=queue.size();
            while(size-->0) {
                int idx=queue.removeFirst();
                int x=idx/m;
                int y=idx%m;
                for(int dir[]:dirs) {
                    int r=x+dir[0];
                    int c=y+dir[1];
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==0) {
                        grid[r][c]=1;
                        queue.addLast(r*m+c);
                    }
                }
            }
            level++;
         }
         return level-1;
    }
}