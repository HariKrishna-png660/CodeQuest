class Solution {
    static String letters[]={"/",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            List<String> baseAns=new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        int firstValue=digits.charAt(0)-'0';
        String currString=letters[firstValue];
        String remString=digits.substring(1);
        List<String> myAns=new ArrayList<>();
        List<String> smallAns=letterCombinations(remString);
        for(int i=0;i<currString.length();i++) {
            char ch=currString.charAt(i);
            for(String s:smallAns) {
                myAns.add(ch+s);
            }
        }
        return myAns;
    }
}