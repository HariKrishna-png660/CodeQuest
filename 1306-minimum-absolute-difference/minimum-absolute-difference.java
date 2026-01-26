class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++) {
            int curr=arr[i];
            int next=arr[i+1];
            minDiff=Math.min(minDiff,next-curr);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-1;i++) {
            int curr=arr[i];
            int next=arr[i+1];
            int diff=next-curr;
            if(diff==minDiff) {
                List<Integer> pair=new ArrayList<>();
                pair.add(curr);
                pair.add(next);
                ans.add(pair);
            }
        }
        return ans;
    }
}