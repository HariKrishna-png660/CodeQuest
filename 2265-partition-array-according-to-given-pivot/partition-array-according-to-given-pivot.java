class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer> lessThanPivot=new ArrayList<>();
        ArrayList<Integer> equalToPivot=new ArrayList<>();
        ArrayList<Integer> greaterThanPivot=new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(nums[i]<pivot) {
                lessThanPivot.add(nums[i]);
            }
            else if(nums[i]==pivot) {
                equalToPivot.add(nums[i]);
            }
            else {
                greaterThanPivot.add(nums[i]);
            }
        }
        int index=0;
        for(int val:lessThanPivot) {
            nums[index++]=val;
        }
        for(int val:equalToPivot) {
            nums[index++]=val;
        }
        for(int val:greaterThanPivot) {
            nums[index++]=val;
        }
        return nums;
    }
}