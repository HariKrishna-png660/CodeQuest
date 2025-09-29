class Solution {
    public void swap(int arr[],int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] nums) {
        // we need four areas here 
        // 0 to p1 -> zeros
        // p1+1 to p2-1 -> ones
        // p2 to p3 -> unexplored
        // p3+1 to n-1 -> twos
        int n=nums.length;
        int p1=-1;
        int p2=0;
        int p3=n-1;
        while(p2<=p3) {
            int val=nums[p2];
            if(val==0) {
                p1++;
                swap(nums,p2,p1);
                p2++;
            }
            else if(val==1) {
                p2++;
            }
            else {
                swap(nums,p2,p3);
                p3--;
            }
        }
    }
}