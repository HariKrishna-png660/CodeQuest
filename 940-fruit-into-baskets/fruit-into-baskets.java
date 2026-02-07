class Solution {
    public int totalFruit(int[] fruits) {
         int n=fruits.length;
         int si=0;
         int ei=0;
         int maxFruits=0;
         int freq[]=new int[(int)1e6];
         int count=0;
         while(ei<n) {
            int currFruit=fruits[ei];
            if(freq[currFruit]==0) {
                count++;
            }
            freq[currFruit]++;
            ei++;
            while(count>2) {
                if(freq[fruits[si]]==1) {
                    count--;
                }
                freq[fruits[si]]--;
                si++;
            }
            maxFruits=Math.max(maxFruits,ei-si);
         }
         return maxFruits;
    }
}