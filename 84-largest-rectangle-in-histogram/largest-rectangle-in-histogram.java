class Solution {
    public int[] previousSmallestElement(int heights[]) {
        int n=heights.length;
        int pse[]=new int[n];
        Arrays.fill(pse,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--) {
            int currElement=heights[i];
            while(st.size()!=0 && heights[st.peek()]>currElement) {
                pse[st.pop()]=i;
            }
            st.push(i);
        }
        return pse;
    }
    public int[] nextSmallerElement(int heights[]) {
        int n=heights.length;
        int nse[]=new int[n];
        Arrays.fill(nse,n);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) {
            int currElement=heights[i];
            while(st.size()>0 && heights[st.peek()]>currElement) {
                nse[st.pop()]=i;
            }
            st.push(i);
        }
        return nse;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int pse[]=previousSmallestElement(heights);
        int nse[]=nextSmallerElement(heights);
        for(int i=0;i<n;i++) {
            System.out.print(pse[i]+" ");
        }
        for(int i=0;i<n;i++) {
            System.out.print(nse[i]+" ");
        }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            maxArea=Math.max(maxArea,(nse[i]-pse[i]-1)*heights[i]);
        }
        return maxArea;
    }
}