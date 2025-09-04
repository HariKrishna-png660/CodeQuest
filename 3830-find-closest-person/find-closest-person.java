class Solution {
    public int findClosest(int x, int y, int z) {
        int val1=Math.abs(x-z);
        int val2=Math.abs(y-z);
        if(val1>val2) {
            return 2;
        }
        else if(val1<val2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}