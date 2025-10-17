class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int count[]=new int[1001];
        for(int i=0;i<trips.length;i++) {
            int np=trips[i][0];
            int l=trips[i][1];
            int h=trips[i][2];
            for(int j=l;j<h;j++) {
                count[j] += np;
            }
        }
        for(int i=0;i<count.length;i++) {
            if(count[i]>capacity) {
                return false;
            }
        }
        return true;
    }
}