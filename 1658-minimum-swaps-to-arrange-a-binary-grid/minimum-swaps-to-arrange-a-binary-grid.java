class Solution {
    public int minSwaps(int[][] grid) {
        // count the trailing zeros in each of the row 
        // store them in an array 
        // for the upper traingle to be filled with all zeros then we need to follow the below pattern
        // 1st row -> 1 and n-1 zeros
        // 2nd row -> 1 1 and n-2 zeros
        // 3rd row -> 1 1 1 and n-3 zeros 
        // 4th row -> 1 1 1 1 and n-4 zeros 
        // nth row -> 1 1 1 1 1 ... n ones and 0 zeros 
        int n=grid.length;
        int count[]=new int[n];
        for(int i=0;i<n;i++) {
            int zeros=0;
            for(int j=n-1;j>=0 && grid[i][j]==0;j--) {
                zeros++;
            }
            count[i]=zeros;
            System.out.println(count[i]);
        }
        int swaps=0;
        for(int i=0;i<n;i++) {
            int needed = n-1-i;
            int j=i;
            while(j<n && count[j]<needed) {
                j++;
            }
            if(j==n) {
                return -1;
            }
            while(j>i) {
                int temp=count[j];
                count[j]=count[j-1];
                count[j-1]=temp;
                j--;
                swaps++;
            }
        }
        return swaps;
    }
}