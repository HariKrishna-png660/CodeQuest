class Solution {
    public boolean areAlternatingGroups(int arr[],int start,int end) {
        for(int i=start+1;i<=end;i++) {
           int prev=arr[i-1];
           int curr=arr[i];
           if(Math.abs(curr-prev)!=1) {
             return false;
           }
        }
        return true;
    }
    public int numberOfAlternatingGroups(int[] colors) {
        int n=colors.length;
        int newColors[]=new int[n+2];
        for(int i=0;i<colors.length;i++) {
              newColors[i]=colors[i];
        }
        // System.out.println(newColors.length);
        newColors[n]=colors[0];
        newColors[n+1]=colors[1];
        int ans=0;
        for(int i=0;i<colors.length;i++) {
             if(areAlternatingGroups(newColors,i,i+2)) {
                ans++;
             }
        }
        return ans;
    }
}