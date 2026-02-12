class Solution {
    public int precedence(char ch) {
        if(ch=='*'||ch=='/') {
            return 2;
        }
        else {
            return 1;
        }
    }
    public int evaluate(int val1,int val2,char op) {
        if(op=='/') {
            return val1/val2;
        }
        else if(op=='*') {
            return val1*val2;
        }
        else if(op=='+') {
            return val1+val2;
        }
        else {
            return val1-val2;
        }
    }
    public int calculate(String s) {
        int n=s.length();
        Stack<Character> operators=new Stack<>();
        Stack<Integer> operands=new Stack<>();
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch==' ') {
                continue;
            }
            else if(Character.isDigit(ch)) {
                int j=i;
                int num=0;
                while(j<n && Character.isDigit(s.charAt(j))) {
                    num=num*10+(s.charAt(j)-'0');
                    j++;
                }
                operands.push(num);
                i=j-1;
            }
            else {
                while(operators.size()!=0 && precedence(operators.peek()) >= precedence(ch)) {
                    int val2=operands.pop();
                    int val1=operands.pop();
                    int value=evaluate(val1,val2,operators.pop());
                    operands.push(value);
                }
               operators.push(ch);
            }
            // System.out.println(operators+"/"+i);
            // System.out.println(operands+"/"+i);
        }
        while(operators.size()!=0) {
            int val1=operands.pop();
            int val2=operands.pop();
            operands.push(evaluate(val2,val1,operators.pop()));
        }
        return operands.peek();
    }
}