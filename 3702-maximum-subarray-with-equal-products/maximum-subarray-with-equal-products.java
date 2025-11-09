class Solution {
    public int GCD(int num1,int num2) {
        while(num2!=0) {
            int temp=num2;
            num2=num1%num2;
            num1=temp;
        }
        return num1;
    }
    public int LCM(int num1,int num2) {
        int gcd=GCD(num1,num2);
        return (num1*num2)/gcd;
    }
    public boolean isProductEquivalent(int nums[],int start,int end) {
        int n=nums.length;
        int lcm=nums[start];
        int gcd=nums[start];
        int product=1;
        for(int i=start;i<=end;i++) {
             lcm=LCM(lcm,nums[i]);
             gcd=GCD(gcd,nums[i]);
             product=product*nums[i];
        }
        return product==(lcm*gcd);
    }
    public int maxLength(int[] nums) {
        int n=nums.length;
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isProductEquivalent(nums,i,j)) {
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
}