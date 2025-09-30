class Solution {
    public long calcSum(int len, int peak) {
        if (len < peak) {
            long last = peak - len;
            return (long)(peak - 1 + last) * len / 2;
        } else {
            long triangle = (long)(peak - 1 + 1) * (peak - 1) / 2;
            return triangle + (len - (peak - 1));
        }
    }

    public boolean isPossible(int n, int index, int maxSum, int mid) {
    long left = calcSum(index, mid);        
    long right = calcSum(n - index - 1, mid); 
    long total = left + right + mid;         

    return total <= maxSum;
}

    public int maxValue(int n, int index, int maxSum) {
        int low=1;
        int high=(int)(1e9);
        int maxVal=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(n,index,maxSum,mid)) {
                maxVal=mid;
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return maxVal;
    }
}