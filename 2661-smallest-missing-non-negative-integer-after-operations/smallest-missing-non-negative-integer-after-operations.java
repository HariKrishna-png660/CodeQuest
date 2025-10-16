class Solution {
    public int findSmallestInteger(int[] nums, int value) {
          int n=nums.length;
          HashMap<Integer,Integer> map=new HashMap<>();
          for(int i=0;i<n;i++) {
            int rem=((nums[i]%value)+value)%value;
            map.put(rem,map.getOrDefault(rem,0)+1);
          }
          for(int i=0;i<n;i++) {
             int r=i%value;
             if(map.containsKey(r)) {
                 if(map.get(r)==1) {
                    map.remove(r);
                 }
                 else {
                    map.put(r,map.get(r)-1);
                 }
             }
             else {
                return i;
             }
          }
          return n;
    }
}