class Solution {
    static String[] keyPad={"/",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    // recursion on the way down 
    // public List<String> letterCombinations(String digits) {
    //     if(digits.length()==0) {
    //         List<String> baseAns=new ArrayList<>();
    //         baseAns.add("");
    //         return baseAns;
    //     }
    //     String remString=digits.substring(1);
    //     char firstChar=digits.charAt(0);
    //     System.out.println(firstChar);
    //     int firstNum=firstChar-'0';
    //     List<String> smallAns=letterCombinations(remString);
    //     String str=keyPad[firstNum];
    //     List<String> myAns=new ArrayList<>();
    //     for(int i=0;i<str.length();i++) {
    //         char ch=str.charAt(i);
    //         for(String s:smallAns) {
    //             myAns.add(ch+s+"");
    //         }
    //     }
    //     return myAns;
    // }
    // recursion on the way up
    public void letterCombinations(String digits,List<String> ans,String sub) {
          if(digits.length()==0) {
              ans.add(sub);
              return;
          }
          String remString=digits.substring(1);
          char firstChar=digits.charAt(0);
          int firstNum=firstChar-'0';
          String str=keyPad[firstNum];
          for(int i=0;i<str.length();i++) {
              char letter=str.charAt(i);
              letterCombinations(remString,ans,sub+letter);
          }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        letterCombinations(digits,ans,"");
        return ans;
    }
}