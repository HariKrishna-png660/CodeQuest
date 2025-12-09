class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        long Mod = 1000000007;
        HashMap<Integer,Integer> rightMap=new HashMap<>();
        for(int i=0;i<n;i++) {
            int val=nums[i];
            rightMap.put(val,rightMap.getOrDefault(val,0)+1);
        }
       HashMap<Integer,Integer> leftMap=new HashMap<>();
       long ans=0;
       for(int i=0;i<n;i++) {
           int val=nums[i];
           if(rightMap.get(val)==1) {
                rightMap.remove(val);
           }
           else {
              rightMap.put(val,rightMap.getOrDefault(val,0)-1);
           }
           if(leftMap.containsKey(2*val) && rightMap.containsKey(2*val)) {
                 long left = leftMap.get(2*val);
                 long right = rightMap.get(2*val);
                 ans = (ans + (left*right)%Mod)%Mod;
           }
           leftMap.put(val,leftMap.getOrDefault(val,0)+1);
       }
       return (int)ans;
    }
}