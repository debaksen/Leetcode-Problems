https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        
        List<List<Character>> bucket = new ArrayList<>();
        HashMap<Character,Integer> freqMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        
        for(char ch : s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        
        for(int i=0;i<=s.length();i++){
            bucket.add(new ArrayList<Character>());
        }
        
        for(char key : freqMap.keySet()){
            int frequency = freqMap.get(key);
            bucket.get(frequency).add(key);
        }
        
        
        for(int i=s.length();i>=0;i--){
           
            if(bucket.get(i) != null || bucket.get(i).size() != 0){
                 List<Character> buffer = bucket.get(i); 
                for(int j=0;j<buffer.size();j++){
                    int charFreq = i; 
                    char ch = buffer.get(j);
                    while(charFreq -- > 0){
                        sb.append(ch);
                    }
                }
            }
        }
        
        return sb.toString(); 
    
    }
}