class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Integer> indices=new ArrayList<>();
        for(int i=0;i<n;i++) {
            int val=nums[i];
            if(val==1) {
                indices.add(i);
            }
        }
        int m=indices.size();
        for(int i=1;i<m;i++) {
                int diff=indices.get(i)-indices.get(i-1);
                if(diff-1<k) {
                    return false;
                }
            
        }
        return true;
    }
}