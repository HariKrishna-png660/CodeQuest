class Solution {
    // TIME COMPLEXITY IS O(N^2)
    // public int countPairs(List<Integer> nums, int target) {
    //     int n=nums.size();
    //     int count=0;
    //     for(int i=0;i<n;i++) {
    //         for(int j=i+1;j<n;j++) {
    //             int sum=nums.get(i)+nums.get(j);
    //             if(sum<target) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // TIME COMPLEXITY IS O(N LOG N)
    // public int countPairs(List<Integer> nums,int target) {
    //       Collections.sort(nums);
    //       int i=0;
    //       int j=nums.size()-1;
    //       int count=0;
    //       while(i<j) {
    //          int sum=nums.get(i)+nums.get(j);
    //          if(sum<target) {
    //             count += (j-i);
    //             i++;
    //          }
    //          else {
    //             j--;
    //          }
    //       }
    //       return count;
    // }
    public int countPairs(List<Integer> nums,int target) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int sum=nums.get(i)+nums.get(j);
                if(sum<target) {
                    ans++;
                }
            }
        }
        return ans;
    }
}