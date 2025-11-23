class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set=new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++) {
            int num=digits[i];
            if(num%2!=0) {
                continue;
            }
            for(int j=0;j<n;j++) {
                int num1=digits[j];
                if(i==j) {
                    continue;
                }
                for(int k=0;k<n;k++) {
                    int num2=digits[k];
                    if(k==i || k==j || num2==0) {
                        continue;
                    }
                  set.add(num2*100+num1*10+num); 
                }
            }
        }
        int size=set.size();
        int ans[]=new int[size];
        int i=0;
        for(int val:set) {
            ans[i++]=val;
        }
        Arrays.sort(ans);
        return ans;
    }
}