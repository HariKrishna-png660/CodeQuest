class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++) {
            int rem=arr[i]%k;
            rem=(rem+k)%k;
            int reqRem=(k-rem)%k;
            if(map.containsKey(reqRem)) {
                count++;
                int val=map.get(reqRem);
                if(val==1) {
                   map.remove(reqRem);
                } 
                else {
                    map.put(reqRem,val-1);
                }
            }
            else {
                 map.put(rem,map.getOrDefault(rem,0)+1);
            }
        }
       return count==n/2;
    }
}