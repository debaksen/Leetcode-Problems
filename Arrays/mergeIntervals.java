class Solution {
    public int[][] merge(int[][] intervals) {
        
        Pair[] pairs = new Pair[intervals.length]; 
        
        for(int i=0;i<intervals.length;i++){
            Pair curr = new Pair(intervals[i][0], intervals[i][1]);
            pairs[i] = curr;
        }
        
        Arrays.sort(pairs);
        
        Stack<Pair> st = new Stack<Pair>();
        for(int curr=0;curr<pairs.length;curr++){
            if(curr == 0) st.push(pairs[curr]);
            
            else{
                Pair top = st.peek();
                if(top.et < pairs[curr].st) st.push(pairs[curr]); 
                
                else{
                    top.et = Math.max(top.et,pairs[curr].et); 
                }
            }
        }
        
        Stack<Pair> revSt = new Stack<Pair>();
        
        while(!st.isEmpty()){
            revSt.push(st.pop());
        }
        int idx = 0; 
        int[][] res = new int[revSt.size()][2];
        while(!revSt.isEmpty()){
            Pair elem = revSt.pop(); 
            res[idx][0] = elem.st;
            res[idx][1] = elem.et;
            
            idx++; 
        }
        
        return res; 
    }
    
    public static class Pair implements Comparable<Pair> {
        int st; 
        int et; 
        
        Pair(int st, int et){
            this.st = st;
            this.et = et; 
        }
        
        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st; 
            }
            else{
                return this.et - other.et;
            }
        }
    }
}