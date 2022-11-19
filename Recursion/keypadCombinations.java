class Solution {
   
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz"); 
        
        List<String> emptyList = new ArrayList<String>(); 
        if(digits.length() == 0) return emptyList; 
        
        return getCombinations(digits,map,"");
        
    }
    
    private static List<String> getCombinations(String digits, Map<Character,String> map, String res){
        
        if(digits.length() == 0){
            List<String> buffer = new ArrayList<String>();
            buffer.add("");
            return buffer; 
        }
        
        char ch = digits.charAt(0);
        String rest = digits.substring(1); 
        List<String> asf = getCombinations(rest,map, res);
        
        List<String> resultList = new ArrayList<String>();
        
        String letterOnChar = map.get(ch);
        for(char ele : letterOnChar.toCharArray()){
            for(String st : asf){
                resultList.add(ele+st); 
            }
        }
        
        return resultList; 
   }
}