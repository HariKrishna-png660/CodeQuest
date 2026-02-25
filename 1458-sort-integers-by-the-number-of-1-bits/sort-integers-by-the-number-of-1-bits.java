class Solution {
    public int numberOfOnesInBinary(int n) {
        int count=0;
        while(n>0) {
            int rem=n%2;
            if(rem==1) {
                count++;
            }
            n=n/2;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++) {
            ArrayList<Integer> al=new ArrayList<>();
            al.add(arr[i]);
            al.add(numberOfOnesInBinary(arr[i]));
            list.add(al);
        }
        Collections.sort(list,(a,b)-> {
        if(a.get(1)==b.get(1)) {
            return a.get(0)-b.get(0);
        }
         return a.get(1)-b.get(1);
        }
        );
        int ans[]=new int[n];
        for(int i=0;i<n;i++) {
            ans[i]=list.get(i).get(0);
        }
        return ans;
    }
}