class Solution {
    public boolean canArrange(int[] arr, int k) {
         int n=arr.length;
         HashMap<Integer,Integer> map=new HashMap<>();
         int pairs=0;
         for(int i=0;i<n;i++) {
            int rem=(arr[i]%k+k)%k;
            int req=((k-rem)+k)%k;
            if(map.containsKey(req)) {
                pairs++;
                int val=map.get(req);
                if(val==1) {
                    map.remove(req);
                }
                else {
                    map.put(req,map.getOrDefault(req,0)-1);
                }
            }
            else {
                map.put(rem,map.getOrDefault(rem,0)+1);
            }
         }
         System.out.println(pairs);
         if(pairs==n/2) {
            return true;
         }
         return false;
    }
}