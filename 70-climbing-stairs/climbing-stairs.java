class Solution {
    // tabulation solution ....
    public int climbStairs(int n,int tab[]) {
        for(int i=1;i<=n;i++) {
            if(i<=2) {
                tab[i]=i;
                continue;
            }
            int oneStep=tab[i-1];
            int twoSteps=tab[i-2];
            tab[i]=oneStep+twoSteps;
        }
        return tab[n];
    }
    public int climbStairs(int n) {
        int tab[]=new int[n+1];
        return climbStairs(n,tab);
    }
}