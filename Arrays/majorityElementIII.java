// https://www.codingninjas.com/codestudio/problems/elements-occur-more-than-n-k-times_1113146

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> countTheNumber(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        
        ArrayList<Integer> res  = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int elem : arr){
        if(map.containsKey(elem))
            map.put(elem,map.get(elem)+1); 
        
        else 
           map.put(elem,1);
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()  >= n/k) res.add(entry.getKey()); 
        }
        return res;
	}
}
