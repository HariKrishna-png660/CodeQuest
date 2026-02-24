class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        ArrayList<Integer> diff=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++) {
            diff.add(Math.abs(s.charAt(i)-t.charAt(i)));
        }
        int si=0;
        int ei=0;
        int m=diff.size();
        int maxLen=0;
        int sum=0;
        while(ei<m) {
            sum += diff.get(ei);
            ei++;
            while(sum > maxCost) {
                  sum -= diff.get(si++);
            }
            maxLen=Math.max(maxLen,ei-si);
        }
        return maxLen;
    }
}