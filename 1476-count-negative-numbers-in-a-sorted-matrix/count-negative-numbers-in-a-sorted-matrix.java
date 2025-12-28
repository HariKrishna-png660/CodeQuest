class Solution {
    // ============ TIME COMPLEXITY IS O(N*M)=========================================
    // public int countNegatives(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int count=0;
    //     for(int i=0;i<n;i++) {
    //         for(int j=0;j<m;j++) {
    //             if(grid[i][j]<0) {
    //               count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // ==============TIME COMPLEXITY IS O(N LOG N)=================
    // public int getNegativeCount(int arr[]) {
    //     int n=arr.length;
    //     int si=0;
    //     int ei=n-1;
    //     int ans=n;
    //     while(si<=ei) {
    //         int mid=(si+ei)/2;
    //         if(arr[mid]<0) {
    //            ans=mid;
    //            ei=mid-1;
    //         }
    //         else {
    //             si=mid+1;
    //         }
    //     }
    //     return ans;
    // }
    // public int countNegatives(int[][] grid) {
    //     int n=grid.length;
    //     int ans=0;
    //     for(int i=0;i<n;i++) {
    //        int negCount=getNegativeCount(grid[i]);
    //        System.out.println(negCount);
    //        ans += grid[i].length-negCount;
    //     }
    //     return ans;
    // }
    // ===========TIME COMPLEXITY IS O(N+M)=============
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int row=m-1;
        int col=0;
        int ans=0;
        while(row>=0 && col<n) {
            if(grid[row][col]>=0) {
                col++;
            }
            else {
                ans += (n-col);
                row--;
            }
        }
        return ans;
    }
}