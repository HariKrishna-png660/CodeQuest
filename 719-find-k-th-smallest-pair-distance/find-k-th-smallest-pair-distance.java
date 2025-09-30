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
    public int smallestDistancePair(int nums[],int k) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            max=Math.max(max,nums[i]);
        }
        int dis[]=new int[max+1];
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int diff=Math.abs(nums[i]-nums[j]);
                dis[diff]++;
            }
        }
        int ans=0;
        for(int i=0;i<=max;i++) {
             k-=dis[i];
             if(k<=0) {
                ans=i;
                break;
             }
        }
        return ans;
    }
}
