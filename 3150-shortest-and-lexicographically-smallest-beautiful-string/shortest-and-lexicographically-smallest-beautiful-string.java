class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int count=0;
        int si=0;
        int ei=0;
        ArrayList<String> list=new ArrayList<>();
        int minLen=Integer.MAX_VALUE;
        while(ei<n) {
            char ch=s.charAt(ei);
            if(ch=='1') {
                count++;
            }
            ei++;
            while(count==k) {
                 list.add(s.substring(si,ei));
                 minLen=Math.min(minLen,ei-si);
                 if(s.charAt(si)=='1') {
                    count--;
                 }
                 si++;
            }
        }
        String ans="2";
        for(String str:list) {
            if(str.length()==minLen && str.compareTo(ans)<0) {
                ans=str;
            } 
        }
        return ans=="2"?"":ans;
    }
}