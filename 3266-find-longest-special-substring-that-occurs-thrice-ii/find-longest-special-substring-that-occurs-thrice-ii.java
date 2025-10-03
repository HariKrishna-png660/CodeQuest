class Solution {
    // TIME COMPLEXITY IS O(N)
    // SPACE COMPLEXITY IS O(N)
    public int maximumLength(String s) {
        int n=s.length();
        int matrix[][]=new int[26][n+1];
        char prevChar=s.charAt(0);
        int length=0;
        for(int i=0;i<n;i++) {
            char currChar=s.charAt(i);
            if(prevChar==currChar) {
                length+=1;
                matrix[currChar-'a'][length]++;
            }
            else {
                length=1;
                matrix[currChar-'a'][length]++;
                prevChar=currChar;
            }
        }
        int result=-1;
        for(int i=0;i<26;i++){
            int currSum=0;
           for(int j=n;j>=0;j--) {
               currSum += matrix[i][j];
               if(currSum>=3) {
                  result =Math.max(result,j);
                  break;
               }
           }
        }
        return result;
    }
}