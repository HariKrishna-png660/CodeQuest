class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list=new ArrayList<>();
        int n=nums1.length;
        int m=nums2.length;
        int i=0;
        int j=0;
        while(i<n && j<m) {
            if(nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }
        int size=list.size();
        int arr[]=new int[size];
        for(int k=0;k<size;k++) {
            arr[k]=list.get(k);
        }
        return arr;
    }
}