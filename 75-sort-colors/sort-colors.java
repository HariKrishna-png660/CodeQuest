class Solution {
    public void swap(int arr[],int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p1=-1;
        int p2=0;
        int p3=n-1;
        while(p2<=p3) {
            if(nums[p2]==0) {
                swap(nums,p1+1,p2);
                p1++;
                p2++;
            }
            else if(nums[p2]==1) {
                p2++;
            }
            else {
                swap(nums,p2,p3);
                p3--;
            }
        }
    }
}