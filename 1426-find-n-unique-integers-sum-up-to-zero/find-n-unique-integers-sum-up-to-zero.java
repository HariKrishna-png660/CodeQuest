class Solution {
    public int[] sumZero(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        int j=1;
        for(int i=0;i<n;i=i+2) {
            if(i==n-1 && n%2!=0) {
                continue;
            }
            list.add(j);
            list.add(-j);
            j++;
        }
        if(n%2!=0) {
            list.add(0);
        }
        int arr[]=new int[list.size()];
        for(int i=0;i<arr.length;i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}