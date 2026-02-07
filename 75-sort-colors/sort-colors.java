class Solution {
    public void swap(int i,int j,int arr[]) {
        int elementAtI=arr[i];
        int elementAtJ=arr[j];
        arr[i]=elementAtJ;
        arr[j]=elementAtI;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p1=-1;
        int p2=0;
        int p3=n-1;
        while(p2<=p3) {
            int element=nums[p2];
            if(element==0) {
                p1++;
                swap(p1,p2,nums);
                p2++;
            }
            else if(element==1) {
                p2++;
            }
            else {
                swap(p2,p3,nums);
                p3--;
            }
        }
    }
}