class Solution {
    // approach 1 
    // public int smallestDistancePair(int[] nums, int k) {
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             list.add(nums[j] - nums[i]); 
    //         }
    //     }
    //     Collections.sort(list);
    //     return list.get(k - 1); 
    // }
    // approach 2
    // public int smallestDistancePair(int nums[],int k) {
    //     Arrays.sort(nums);
    //     PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    //     int n=nums.length;
    //     for(int i=0;i<n;i++) {
    //         for(int j=i+1;j<n;j++) {
    //             pq.add(nums[j]-nums[i]);
    //             if(pq.size()>k) {
    //                 pq.remove();
    //             }
    //         }
    //     }
    //     return pq.remove();
    // }
    // approach 3 
    // public int smallestDistancePair(int nums[],int k) {
    //     int max=Integer.MIN_VALUE;
    //     int n=nums.length;
    //     for(int i=0;i<n;i++) {
    //         max=Math.max(max,nums[i]);
    //     }
    //     int dis[]=new int[max+1];
    //     for(int i=0;i<n;i++) {
    //         for(int j=i+1;j<n;j++) {
    //             int diff=Math.abs(nums[i]-nums[j]);
    //             dis[diff]++;
    //         }
    //     }
    //     int ans=0;
    //     for(int i=0;i<=max;i++) {
    //          k-=dis[i];
    //          if(k<=0) {
    //             ans=i;
    //             break;
    //          }
    //     }
    //     return ans;
    // }
    // OPTIMAL APPROACH (SLIDING WINDOW + BINARY SEARCH)
    public boolean isPossible(int nums[],int maxDis,int k){
        int count=0;
        int left=0;
        for(int right=0;right<nums.length;right++) {
            while(nums[right]-nums[left]>maxDis) {
                left++;
            }
            count += right-left;
        }
        return count>=k;
    }
     public int smallestDistancePair(int nums[],int k) {
         Arrays.sort(nums);
         int n=nums.length;
         int low=0;
         int high=nums[n-1]-nums[0];
         int dis=0;
         while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(nums,mid,k)) {
                dis=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
         }
         return dis;
     }
}
