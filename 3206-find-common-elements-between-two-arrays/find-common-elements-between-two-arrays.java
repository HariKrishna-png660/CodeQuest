class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        // store both nums1 and nums2 in hash map
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++) {
            int value=nums1[i];
            map1.put(value,map1.getOrDefault(value,0)+1);
        }
        for(int i=0;i<m;i++) {
            int value=nums2[i];
            map2.put(value,map2.getOrDefault(value,0)+1);
        }
        // iterate on nums1 and track common elements from nums2
        int common1=0;
        for(int i=0;i<n;i++) {
            int value=nums1[i];
            if(map2.containsKey(value)) {
                int val=map2.get(value);
                common1++;
            }
        }
        int common2=0;
        for(int i=0;i<m;i++) {
            int value=nums2[i];
            if(map1.containsKey(value)) {
                int val=map1.get(value);
                common2++;
            }
        }
        return new int[]{common1,common2};
    }
}