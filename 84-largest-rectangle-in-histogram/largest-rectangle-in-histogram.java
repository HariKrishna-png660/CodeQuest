class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++) {
            while(st.peek()!=-1 && heights[st.peek()]>heights[i]) {
                 int height=heights[st.pop()];
                int nsr=i;
                int nsl=-1;
                if(st.size()>0) {
                   nsl=st.peek();
                }
                maxArea=Math.max(maxArea,(nsr-nsl-1)*height);
            }
           st.push(i);
        }
        while(st.peek()!=-1) {
            int height=heights[st.pop()];
            int nsr=n;
            int nsl=st.peek();
             maxArea=Math.max(maxArea,(nsr-nsl-1)*height);
        }
        return maxArea;
    }
}