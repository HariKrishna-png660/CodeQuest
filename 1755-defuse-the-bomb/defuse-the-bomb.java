class Solution {
    public int getSum(int arr[],int start,int end) {
        int sum=0;
        for(int i=start;i<=end;i++) {
             sum += arr[i];
        }
        return sum;
    }
    public int[] decrypt(int[] code, int k) {
         int m=code.length;
        // add n-1 elements to the starting and n-1 elements to the ending
        ArrayList<Integer> list=new ArrayList<>();
        // adding n-1 elements to the starting
        for(int i=1;i<m;i++) {
            list.add(code[i]);
        }
        // add the code array
        for(int i=0;i<m;i++) {
            list.add(code[i]);
        }
        // add the n-1 elements to the ending
        for(int i=0;i<m-1;i++) {
            list.add(code[i]);
        }
        int n=list.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=list.get(i);
        }
       
        // start=k end=k+m-1
        int start=m-1;
        int end=start+m-1;
        int ans[]=new int[m];
        int ind=0;
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        for(int i=start;i<=end;i++) {
            if(k<0) {
                int K=Math.abs(k);
               int sum=getSum(arr,i-K,i-1);
               ans[ind++]=sum;
            }
            else if(k>0) {
               int sum=getSum(arr,i+1,i+k);
               ans[ind++]=sum;
            }
            else {
               ans[ind++]=0;
            }
        }
        return ans;
    }
}