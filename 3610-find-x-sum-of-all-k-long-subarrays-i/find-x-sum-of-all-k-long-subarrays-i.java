class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        HashMap<Integer,Integer> map=new HashMap<>();
        int si=0;
        int ei=0;
        int j=0;
        while(ei<n) {
            int i=0;
            int val=nums[ei];
            map.put(val,map.getOrDefault(val,0)+1);
            ei++;
            if(ei-si>k) {
                int key=nums[si];
                int value=map.get(key);
                if(value==1) {
                    map.remove(key);
                }
                else {
                    map.put(key,value-1);
                }
                si++;
            }
            if(ei-si==k) {
                // create a priority queue of type array 
                PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
                    if(a[1]!=b[1]) {
                        return b[1]-a[1];
                    }
                    return b[0]-a[0];
                });
                for(int key:map.keySet()) {
                    pq.add(new int[]{key,map.get(key)});
                }
                int count=0;
                int pick=x;
                while(pick>0 && pq.size()!=0) {
                    int top[]=pq.remove();
                    count += (top[0]*top[1]);
                    pick--;
                }
                ans[j]=count;
                j++;
            }
        }
        return ans;
    }
}