class Solution {
    // public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    //     int n=aliceSizes.length;
    //     int m=bobSizes.length;
    //     int sumA=0;
    //     int sumB=0;
    //     for(int i=0;i<n;i++) {
    //         sumA += aliceSizes[i];
    //     }
    //     for(int j=0;j<m;j++) {
    //         sumB += bobSizes[j];
    //     }
    //     for(int i=0;i<n;i++) {
    //         for(int j=0;j<m;j++) {
    //             if(sumA-aliceSizes[i]+bobSizes[j]==sumB+aliceSizes[i]-bobSizes[j]) {
    //                 return new int[]{aliceSizes[i],bobSizes[j]};
    //             }
    //         }
    //     }
    //     return new int[]{};
    // }
    public int[] fairCandySwap(int aliceSizes[],int bobSizes[]) {
        Set<Integer> setB=new HashSet<>();
        int n=aliceSizes.length;
        int m=bobSizes.length;
        int sumA=0;
        int sumB=0;
        for(int i=0;i<n;i++) {
            sumA += aliceSizes[i];
        }
        for(int i=0;i<m;i++) {
            sumB += bobSizes[i];
            setB.add(bobSizes[i]);
        }
        int diff=(sumB-sumA)/2;
        for(int val:aliceSizes) {
            if(setB.contains(val+diff)) {
                return new int[]{val,val+diff};
            }
        }
        return new int[]{};
    }
}