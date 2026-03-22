class Solution {
    public boolean isValid(String s) {
        int m=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<m;i++) {
            char ch=s.charAt(i);
            st.push(ch);
            int n=st.size();
            if(st.size() >=3 && st.get(n-3) == 'a' && st.get(n-2) == 'b' && st.get(n-1) == 'c') {
                st.pop();
                st.pop();
                st.pop();
            }
        }
        return st.isEmpty();
    }
}