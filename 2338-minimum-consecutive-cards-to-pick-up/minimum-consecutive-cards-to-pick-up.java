class Solution {
    public int minimumCardPickup(int[] cards) {
        int n=cards.length;
        int si=0;
        int ei=0;
        int count=0;
        int freq[]=new int[1000001];
        int minLen=Integer.MAX_VALUE;
        while(ei<n) {
            if(freq[cards[ei]]==1) {
                count++;
            }
            freq[cards[ei]]++;
            ei++;
            while(count>0) {
                if(freq[cards[si]]==2) {
                    count--;
                }
                freq[cards[si]]--;
                minLen=Math.min(minLen,ei-si);
                si++;
            }
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}