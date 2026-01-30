class Solution {
    public boolean isValid(String str) {
        int n=str.length();
        Stack<Character> st=new Stack<>();
        // iterate through every character in the string
        for(int i=0;i<n;i++) {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{'||ch=='[') {
                st.push(ch);
                continue;
            }
            else if(ch==')' && (st.size()==0 || st.peek()!='(')) {
                return false;
            }
            else if(ch==']' && (st.size()==0 || st.peek()!='[')) {
                return false;
            }
            else if(ch=='}' && (st.size()==0 || st.peek()!='{')) {
                return false;
            }
            st.pop();
        }
        if(st.size()==0) {
            return true;
        }
        return false;
    }
}