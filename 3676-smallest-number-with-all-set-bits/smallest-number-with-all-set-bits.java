class Solution {
    public int smallestNumber(int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        int p=1;
        for(int i=1;i<=11;i++) {
            p=p*2;
            ans.add(p-1);
        }
        int low=0;
        int high=ans.size()-1;
        int smallNum=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(ans.get(mid)>=n) {
               smallNum=ans.get(mid);
               high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return smallNum;
    }
}