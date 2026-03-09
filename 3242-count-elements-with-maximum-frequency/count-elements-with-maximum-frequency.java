class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            int val=nums[i];
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int maxFreq=0;
        for(int val:map.values()) {
            maxFreq=Math.max(maxFreq,val);
        }
        int count=0;
        for(int val:map.values()) {
            if(val==maxFreq) {
                count++;
            }
        }
        return count*maxFreq;
    }
}