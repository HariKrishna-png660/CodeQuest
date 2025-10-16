class Solution {
    public int findSmallestInteger(int[] nums, int value) {
          int n=nums.length;
          HashMap<Integer,Integer> map=new HashMap<>();
          for(int i=0;i<n;i++) {
            int rem=((nums[i]%value)+value)%value;
            map.put(rem,map.getOrDefault(rem,0)+1);
          }
          int MEX=0;
          while(map.getOrDefault(MEX % value,0)>0) {
            map.put(MEX % value,map.get(MEX % value)-1);
             MEX++;
          }
          return MEX;
    }
}