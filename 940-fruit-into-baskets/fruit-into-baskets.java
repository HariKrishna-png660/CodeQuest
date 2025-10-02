class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int si=0;
        int ei=0;
        int count=0;
        int maxLen=0;
        int freq[]=new int[100001];
        while(ei<n) {
            if(freq[fruits[ei]]==0) {
                count++;
            }
            freq[fruits[ei]]++;
            ei++;
            while(count>2) {
                if(freq[fruits[si]]==1) {
                    count--;
                }
                freq[fruits[si]]--;
                si++;
            }
            maxLen=Math.max(maxLen,ei-si);
        }
        return maxLen;
    }
}