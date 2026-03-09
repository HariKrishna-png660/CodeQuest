class Solution {
    public boolean canArrange(int[] arr, int k) {
          // ((num % k) + k)%k -> curr
          // (k-curr)%k  -> req %k is specially for case when curr is zero 
          int n=arr.length;
          HashMap<Integer,Integer> map=new HashMap<>();
          int count=0;
          for(int i=0;i<n;i++) {
              int curr=((arr[i]%k)+k)%k;
              int req=(k-curr)%k;
            //   System.out.println(curr+" "+req);
              if(map.containsKey(req)) {
                count++;
                 int val=map.get(req);
                 if(val==1) {
                    map.remove(req);
                 }
                 else {
                    map.put(req,val-1);
                 }
              }
              else {
                 map.put(curr,map.getOrDefault(curr,0)+1);
              }
            //   System.out.println(count);
          }
        //   System.out.println(count);
         return count==n/2;
    }
}