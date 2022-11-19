https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charList = new HashSet<>();
        int aPointer = 0;
        int maxLen = 0; 
        
        char[] chArr = s.toCharArray();
        
        for(int i=0;i<chArr.length;i++){
            if(charList.contains(chArr[i])){
                while(chArr[aPointer] != chArr[i]){
                    charList.remove(chArr[aPointer]); 
                    aPointer++;
                }
                charList.remove(chArr[aPointer]); 
                    aPointer++;
            }
            
            charList.add(chArr[i]); 
            maxLen = Math.max(maxLen, charList.size()); 
        }
        
        return maxLen; 
    }
}