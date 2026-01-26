class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            int value=nums1[i];
            map.put(value,map.getOrDefault(value,0)+1);
        }
        ArrayList<Integer> common=new ArrayList<>();
        for(int i=0;i<m;i++) {
            int value=nums2[i];
            if(map.containsKey(value)) {
                common.add(value);
                map.remove(value);
            }
        }
        int size=common.size();
        int ans[]=new int[size];
        for(int i=0;i<size;i++) {
            ans[i]=common.get(i);
        }
        return ans;
    }
}