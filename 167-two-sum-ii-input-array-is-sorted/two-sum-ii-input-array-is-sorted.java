class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int si=0;
        int ei=n-1;
        while(si<ei) {
            int sum=numbers[si]+numbers[ei];
            if(sum<target) {
                si++;
            }
            else if(sum>target) {
                ei--;
            }
            else {
                return new int[]{si+1,ei+1};
            }
        }
        return new int[]{};
    }
}