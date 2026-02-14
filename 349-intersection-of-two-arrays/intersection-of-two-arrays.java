class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        for(int i=0;i<n;i++) {
           set.add(nums1[i]);
        }
        for(int i=0;i<m;i++) {
            if(set.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }
        int res[]=new int[ans.size()];
        int i=0;
        for(int val:ans) {
            res[i++]=val;
        }
        return res;
    }
}