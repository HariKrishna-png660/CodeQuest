class Solution {
    static String letters[]={"/",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void letterCombinations(String digits,String sub,List<String> ans) {
        if(digits.length()==0) {
            ans.add(sub);
            return;
        }
        char firstChar=digits.charAt(0);
        String remString=digits.substring(1);
        int index=firstChar-'0';
        String letter=letters[index];
        for(int i=0;i<letter.length();i++) {
            char ch=letter.charAt(i);
            letterCombinations(remString,sub+ch,ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        letterCombinations(digits,"",ans);
        return ans;
    }
}