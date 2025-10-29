class Solution {
    public int smallestNumber(int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        int p=1;
        for(int i=1;i<=11;i++) {
            p=p*2;
            ans.add(p-1);
        }
        for(int i=0;i<ans.size();i++) {
            int val=ans.get(i);
            if(n<=val) {
                return val;
            }
        }
        return -1;
    }
}