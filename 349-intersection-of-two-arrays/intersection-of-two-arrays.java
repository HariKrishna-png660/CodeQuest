class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         int n=nums1.length;
         int m=nums2.length;
         HashMap<Integer,Integer> map1=new HashMap<>();
         HashMap<Integer,Integer> map2=new HashMap<>();
         for(int i=0;i<n;i++) {
            int val=nums1[i];
            map1.put(val,map1.getOrDefault(val,0)+1);
         }
         for(int i=0;i<m;i++) {
            int val=nums2[i];
            map2.put(val,map2.getOrDefault(val,0)+1);
         }
         // iterate on any one of the hashMap 
         ArrayList<Integer> list=new ArrayList<>();
         for(int key:map1.keySet()) {
              if(map2.containsKey(key)) {
                 list.add(key);
              }
         }
         int size=list.size();
         int ans[]=new int[size];
         int i=0;
         for(int val:list) {
            ans[i++]=val;
         }
         return ans;
    }
}