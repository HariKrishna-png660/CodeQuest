class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set=new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++) {
            int num1=digits[i];
            if(num1==0) {
                continue;
            }
            for(int j=0;j<n;j++) {
                if(i==j) {
                    continue;
                }
                int num2=digits[j];
                for(int k=0;k<n;k++) {
                     int num3=digits[k];
                    if(k==i || k==j || num3%2!=0) {
                        continue;
                    }
                    set.add(num1*100+num2*10+num3);
                }
            }
        }
       return set.size();
    }
}