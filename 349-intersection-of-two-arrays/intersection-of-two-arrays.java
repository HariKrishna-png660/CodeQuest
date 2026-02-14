class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashMap<Integer,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++) {
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        HashMap<Integer,Integer> ans=new HashMap<>();
        for(int i=0;i<m;i++) {
            if(map1.containsKey(nums2[i]) && !ans.containsKey(nums2[i])) {
                ans.put(nums2[i],1);
            } 
        }
        int res[]=new int[ans.size()];
        int i=0;
        for(int key:ans.keySet()) {
            res[i++]=key;
        }
        return res;
    }
}