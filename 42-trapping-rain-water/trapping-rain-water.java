class Solution {
    // one iteration 
    // time = O(N)
    // space =O(N)
    public int trap(int[] height) {
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int trappedWater=0;
        for(int i=0;i<n;i++) {
            while(st.size()>0 && height[st.peek()] < height[i]) {
                int currentIdx=st.pop();
                if(st.size()==0) {
                    break;
                }
                int right=i;
                int left=st.peek();
                int allowedHeight=Math.min(height[right],height[left]);
                int h=allowedHeight-height[currentIdx];
                int w=right-left-1;
                trappedWater += h*w;
            }
            st.push(i);
        }
        return trappedWater;
    }
}