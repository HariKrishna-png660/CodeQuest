class Solution {
    public int totalMoney(int n) {
        int monDayMoney=1;
        int totalMoney=0;
        int j=0;
        int start=1;
        int end=1;
        for(int i=1;i<=n;i++) {
            if((end-start)==7) {
                monDayMoney++;
                j=0;
                start=end;
            }
            totalMoney += (monDayMoney+j);
            j++;
            end++;
        }
        return totalMoney;
    }
}