class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        // prefix min is used to fix the nums[i]
        // we iterate on nums to fix the nums[j]
        // we find the nums[k] in the stack 
        Stack<Integer> st=new Stack<>();
        int preMin[]=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            min=Math.min(min,nums[i]);
            preMin[i]=min;
        }
        for(int i=n-1;i>=0;i--) {
            int elementAtI=preMin[i];
            int elementAtJ=nums[i];
            if(elementAtI == elementAtJ) {
                st.push(elementAtI);
                continue;
            }
            // find the suitable value of nums[k]
            while(st.size()>0 && st.peek()<=elementAtI) {
                  st.pop();
            }
            if(st.size()>0 && st.peek()<elementAtJ) {
                return true;
            }
            st.push(elementAtJ);
        }
        return false;
    }
}