class Solution {
    public int findInsertionIndex(ArrayList<Integer> lis,int ele) {
        int n=lis.size();
        int si=0;
        int ei=n-1;
        int ans=n;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(lis.get(mid)>=ele) {
                ans=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        return ans;
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Arrays.sort(envelopes,(a,b)-> {
            if(a[0]==b[0]) {
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        ArrayList<Integer> lis=new ArrayList<>();
        for(int i=0;i<n;i++) {
            int ele=envelopes[i][1];
            int idx=findInsertionIndex(lis,ele);
            if(idx==lis.size()) {
                lis.add(ele);
            }
            else {
               lis.set(idx,ele);
            }
        }
        return lis.size();
    }
}