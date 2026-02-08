class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();
        // iterate on each of the element of the string
        for(int i=0;i<n;i++) {
            char curr=num.charAt(i);
            // if the current value is less than the value at the tp of the stack 
            while(st.size()>0 && k>0 && st.peek()>curr) {
                st.pop();
                k--;
            }
            if(st.size()==0 && curr=='0') {
                continue;
            }
            st.push(curr);
        }
        while(k>0 && st.size()>0) {
             st.pop();
             k--;
        }
        if(st.size()==0) {
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<st.size();i++) {
            sb.append(st.get(i));
        }
        return sb.toString();
    }
}