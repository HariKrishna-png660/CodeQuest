class Solution {
    public int calculate(String s) {
        Stack<Long> st = new Stack<>();
        long result = 0;
        long num = 0;
        long sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            }
            else if (c == ')') {
                result += sign * num;
                num = 0;

                result *= st.pop();
                result += st.pop();
            }
        }

        return (int)(result + sign * num);
    }
}