class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> broken = new HashSet<>();
        
        for (char ch : brokenLetters.toCharArray()) {
            broken.add(ch);
        }
        
        int count = 0;
        for (String word : words) {
            boolean canType = true;
            for (char ch : word.toCharArray()) {
                if (broken.contains(ch)) {
                    canType = false;
                    break;
                }
            }
            if (canType) count++;
        }
        
        return count;
    }
}
