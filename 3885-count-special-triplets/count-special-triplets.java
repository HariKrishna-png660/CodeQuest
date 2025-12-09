class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> validI=new HashMap<>();
        HashMap<Integer,Integer> validJ=new HashMap<>();
        int M = (int)1e9 + 7;
        int result=0;
        for(int num:nums) {
            if(num%2==0) {
                result =(result+validJ.getOrDefault(num/2,0)) % M;
            }
            int updatedJ=(validJ.getOrDefault(num,0)+validI.getOrDefault(num*2,0))%M;
            validJ.put(num,updatedJ);
            validI.put(num,validI.getOrDefault(num,0)+1);
        }
        return result;
    }
}