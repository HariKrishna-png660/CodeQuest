class Solution {
    public String rotate(String s,int b) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        reverseRange(sb,0,b-1);
        reverseRange(sb,b,sb.length()-1);
        return sb.toString();
    }
    public void reverseRange(StringBuilder sb,int left,int right) {
        while(left<right) {
            char temp=sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,temp);
            left++;
            right--;
        }
    }
    public String findLexSmallestString(String s, int a, int b) {
          String smallestString=s;
          LinkedList<String> queue=new LinkedList<>();
          Set<String> visited=new HashSet<>();
          queue.add(s);
          visited.add(s);

          while(!queue.isEmpty()) {
              String curr=queue.removeFirst();
              if(curr.compareTo(smallestString)<0) {
                  smallestString=curr;
              }

              // adding a to digits at odd indices
              char added[]=curr.toCharArray();
              for(int i=1;i<added.length;i+=2) {
                  int newDigit=((added[i]-'0')+a)%10;
                  added[i]=(char)('0'+newDigit);
              }
              String addedStr=new String(added);
              if(visited.add(addedStr)) {
                  queue.add(addedStr);
              }
              String rotated=rotate(curr,b);
              if(visited.add(rotated)) {
                 queue.add(rotated);
              }
          }
        return smallestString;
    }
}