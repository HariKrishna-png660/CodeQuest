class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int ans[]=new int[2];
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++) {
            int val=nums1[i];
            map1.put(val,map1.getOrDefault(val,0)+1);
        }
        for(int i=0;i<m;i++) {
            int val=nums2[i];
            map2.put(val,map2.getOrDefault(val,0)+1);
        }
        // iterate on nums1 
        for(int i=0;i<n;i++) {
            int val=nums1[i];
            if(map2.containsKey(val)) {
                ans[0]++;
            }
        }
        // iterate on nums2
        for(int i=0;i<m;i++) {
            int val=nums2[i];
            if(map1.containsKey(val)) {
                ans[1]++;
            }
        }
        return ans;
    }
}