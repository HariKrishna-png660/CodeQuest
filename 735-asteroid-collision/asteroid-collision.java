class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) {
            int currentVal=asteroids[i];
            if(currentVal > 0) {
                st.push(currentVal);
            }
            else {
               boolean canPush=true;
               while(st.size() > 0 && st.peek()>0) {
                   // current is a -ve and the number below it ca be +ve or neg
                   // if it is neg then go out of the loop 
                   // else we need to check for some magnitude values
                   // if they are of same magni's then curr is not pushed into the stack
                   // if below is of less magni then we pop 
                   // if below is of more magni then we do nithing
                   if(st.peek() == -(currentVal)) {
                        canPush=false;
                        st.pop();
                        break;
                   }
                   else if(st.peek() < -(currentVal)) {
                       canPush=true;
                       st.pop();
                   }
                   else {
                       canPush=false;
                       break;
                   }
               }
               if(canPush) {
                  st.push(currentVal);
               }
            }
        }
        int ans[]=new int[st.size()];
        int j=st.size()-1;
        for(;j>=0;j--) {
            ans[j]=st.pop();
        }
        return ans;
    }
}