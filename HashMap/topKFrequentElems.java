class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == k) return nums; 
        List<List<Integer>> bucket = new ArrayList<>();
     
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int elem : nums){
            int val = hm.getOrDefault(elem,0); 
            hm.put(elem,val+1);
        }
        
        for(int i=0 ;i<=nums.length+1 ; i++)
        {
        bucket.add(new ArrayList<Integer>());
        }
        
        for(int elem : hm.keySet()){
            int freq = hm.get(elem); 
            bucket.get(freq).add(elem); 
        }
        
        int[] res = new int[k];
        int counter = 0; 
        for(int curr=nums.length;curr>0 && counter<k;curr--){
            
            if(bucket.get(curr) != null){
              List<Integer> currBucket = bucket.get(curr);
              int bucketCounter = 0; 
              while(bucketCounter<currBucket.size()){
                  if(counter > k-1) break; 
                  res[counter++] = currBucket.get(bucketCounter++); 
              }
            }
        }
        
        return res; 
    }
}