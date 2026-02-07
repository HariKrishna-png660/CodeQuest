class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }
        int maxLength=0;
        for(int i=0;i<n;i++) {
            int currNum=nums[i];
            if(!set.contains(currNum)) {
                 continue;
            }
            int prevNum=currNum-1;
            int nextNum=currNum+1;
            while(set.contains(prevNum)) {
                set.remove(prevNum);
                prevNum--;
            }
            while(set.contains(nextNum)) {
                set.remove(nextNum);
                nextNum++;
            }
            maxLength=Math.max(maxLength,nextNum-prevNum-1);
            set.remove(currNum);
        }
        return maxLength;
    }
}