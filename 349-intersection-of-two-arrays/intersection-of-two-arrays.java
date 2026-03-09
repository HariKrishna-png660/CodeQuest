class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<n;i++) {
            int val=nums1[i];
            set1.add(val);
        }
        for(int i=0;i<m;i++) {
            int val=nums2[i];
            set2.add(val);
        }
        // iterate on the values in any set 
        // check whether the value is present in the other set 
        // if yes then add to the arraylist
        ArrayList<Integer> list=new ArrayList<>();
        for(int val:set1) {
            if(set2.contains(val)) {
                list.add(val);
            }
        }
        int size=list.size();
        int ans[]=new int[size];
        for(int i=0;i<size;i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}