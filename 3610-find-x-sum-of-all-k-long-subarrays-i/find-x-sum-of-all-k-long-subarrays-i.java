class Solution {
    public int getXsum(int arr[],int start,int end,int maxLim) {
        int freq[]=new int[51];
        for(int i=start;i<=end;i++) {
            int val=arr[i];
            freq[val]++;
        }
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=1;i<=50;i++) {
            int val=freq[i];
            ArrayList<Integer> l1=new ArrayList<>();
            l1.add(i);
            l1.add(val);
            list.add(l1);
        }
        Collections.sort(list,(a,b)-> {
            int cmp=Integer.compare(b.get(1),a.get(1));
            if(cmp==0) {
                return Integer.compare(b.get(0),a.get(0));
            }
            return cmp;
        });
        int size=list.size();
        int ans=0;
        int i=0;
        while(size>0 && maxLim>0) {
            ans += (list.get(i).get(0)*list.get(i).get(1));
            maxLim--;
            size--;
            i++;
        }
       return ans;
    }
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<n-k+1;i++) {
           int xSum=getXsum(nums,i,i+k-1,x);
           ans[i]=xSum;
        }
        return ans;
    }
}