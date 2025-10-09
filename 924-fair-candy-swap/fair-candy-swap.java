class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int n=aliceSizes.length;
        int m=bobSizes.length;
        int sumA=0;
        int sumB=0;
        for(int i=0;i<n;i++) {
            sumA += aliceSizes[i];
        }
        for(int j=0;j<m;j++) {
            sumB += bobSizes[j];
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(sumA-aliceSizes[i]+bobSizes[j]==sumB+aliceSizes[i]-bobSizes[j]) {
                    return new int[]{aliceSizes[i],bobSizes[j]};
                }
            }
        }
        return new int[]{};
    }
}