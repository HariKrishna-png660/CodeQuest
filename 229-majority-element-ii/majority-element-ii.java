class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // majority element in this case is element that appears more than n/3 times right.
        // so lets say if there are 3 elements that appear more than n/3 times then in that case the total elements in the array exceeds n
        // because (n/3)+(n/3)+(n/3) == n
        // so from the above observations we can conclude that at max there can be two majority elements
        int n=nums.length;
        int candidate1=-1;
        int count1=0;
        int candidate2=-1;
        int count2=0;
        for(int i=0;i<n;i++) {
            if(count1==0 && candidate2!=nums[i]) {
                candidate1=nums[i];
                count1=1;
            }
            else if(count2==0 && candidate1!=nums[i]) {
                candidate2=nums[i];
                count2=1;
            }
            else if(nums[i]==candidate1) {
                count1++;
            }
            else if(nums[i]==candidate2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==candidate1) {
                count1++;
            }
            else if(nums[i]==candidate2) {
                count2++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        if(count1>n/3) {
            ans.add(candidate1);
        }
        if(count2>n/3) {
            ans.add(candidate2);
        }
        return ans;
    }
}