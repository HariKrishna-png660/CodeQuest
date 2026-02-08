class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // first intution is checking wheather the current element is positive or negative 
        // if the current element is positive then it means that no asteriod before the current asteriod will collide with the current asteriod
        // if the current asteriods is negative then we have two cases either the before asteriods is positive or negative
        // if the before asteriod is +ve then it means that they are going to collide 
        // the value of the before asteriod is greater than the current asteriod then current asteriod is going to die 
        // the value of the before asteriod is less than the current asteriod then current asteriod is going to kill that asteriod and also check for before asteriods
        // the value value of the asteriod is equal to the current asteriod then it means that the current asteriod and the before asteriod both are going to die 
        // if the before asteriod is -ve then it means that they are not going to collide 
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        // iterate on each of the element of the array
        for(int i=0;i<n;i++) {
            int currentValue=asteroids[i];
            if(currentValue>0) {
                st.push(currentValue);
            }
            else {
                boolean canPush=true;
                while(st.size()>0 && st.peek()>0) {
                    if(st.peek() < -(currentValue)) {
                        st.pop();
                    }
                    else if(st.peek() == -(currentValue)) {
                        canPush=false;
                        st.pop();
                        break;
                    }
                    else {
                        canPush=false;
                        break;
                    }
                }
                if(canPush) {
                    st.push(currentValue);
                }
            }
        }
        int ans[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--) {
            ans[i]=st.get(i);
        }
        return ans;
    }
}