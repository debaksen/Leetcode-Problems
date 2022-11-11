https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        int k = p.length()-1; 
        
        for(char ch : p.toCharArray()){
            pMap.put(ch,pMap.getOrDefault(ch,0)+1);
        }
        
        int windowStart = 0;
        for(int windowEnd =0; windowEnd<=s.length();windowEnd++){
            
            if(windowEnd > k){
                if(pMap.equals(sMap)) res.add(windowStart); 
                
                 char charAtStart = s.charAt(windowStart);
                 int startCharFreq = sMap.get(charAtStart);
                 
                 if( startCharFreq <= 1){
                     sMap.remove(charAtStart); 
                 }else {
                     sMap.put(charAtStart,startCharFreq -1); 
                 }
                 windowStart++; 
            }
            
            if(windowEnd >= s.length()) break; 
            
            char ch = s.charAt(windowEnd);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
        }
        
        return res; 
    }
}