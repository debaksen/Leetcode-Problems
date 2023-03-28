// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

class Pair implements Comparable<Pair> {
    int vertex; 
    int cost; 
    
    Pair(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost; 
    }
    
    public int compareTo(Pair p){
        return this.cost - p.cost; 
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
    
    ArrayList<ArrayList<ArrayList<Integer>>> graph = makeDislikeGraph(edges,V);
    
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int[] cost = new int[V]; 
    Arrays.fill(cost,-1);
    
    pq.add(new Pair(0,0)); 
    // System.out.println(graph);
    
    while(!pq.isEmpty()){
        Pair currEle = pq.remove();
        int currVertex = currEle.vertex;
        int currCost = currEle.cost;
        
        if(cost[currVertex] != -1) continue;
        
        cost[currVertex] = currCost;
        
        ArrayList<ArrayList<Integer>> neighbours = graph.get(currVertex);
        
        for(ArrayList<Integer> currNeigh : neighbours){
            int neighbourVertex  = currNeigh.get(0);
            int neighbourCost = currNeigh.get(1); 
            
            pq.add(new Pair(neighbourVertex,neighbourCost));
        }
        }
        
        int res = 0;
        for(Integer curr : cost){
            res+= curr;
        }
        
        return res; 
    }
    
	private static ArrayList<ArrayList<ArrayList<Integer>>> makeDislikeGraph(int[][] dislikes, int n){
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<ArrayList<Integer>>()); 
        }

        for(int[] curr : dislikes){
            ArrayList<Integer> buff1 = new ArrayList<>();
            buff1.add(curr[1]); 
            buff1.add(curr[2]); 

            ArrayList<Integer> buff2 = new ArrayList<>();
            buff2.add(curr[0]); 
            buff2.add(curr[2]); 
            
            graph.get(curr[0]).add(buff1);
            graph.get(curr[1]).add(buff2);
        }

        return graph; 
    }
}