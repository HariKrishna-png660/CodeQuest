class Solution {
    public int atMost(int nums[],int k) {
        int n=nums.length;
        int si=0;
        int ei=0;
        int ans=0;
        int freq[]=new int[2001];
        int count=0;
        while(ei<n) {
            if(freq[nums[ei]]==0) {
                 count++;
             }
           freq[nums[ei]]++;
           ei++;
           while(count>k) {
             if(freq[nums[si]]==1) {
                count--;
             }
             freq[nums[si]]--;
             si++;
           }
          ans += (ei-si);
        }
        return ans;
    }
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }
        int k=set.size();
        return atMost(nums,k)-atMost(nums,k-1);
    }
}