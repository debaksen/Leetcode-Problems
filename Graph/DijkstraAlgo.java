// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

class Pair implements Comparable<Pair>{
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

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] costs = new int[V];
        Arrays.fill(costs,-1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));
        
        while(!pq.isEmpty()){
            Pair currPair = pq.remove();
            int currVertex = currPair.vertex;
            int currCost = currPair.cost; 
            
            if(costs[currVertex] != -1) continue;
            
            costs[currVertex] = currCost; 
            
            ArrayList<ArrayList<Integer>> neighbours = adj.get(currVertex);
            for(ArrayList<Integer> current : neighbours){
                int currentNeigh = current.get(0);
                int currentEdgeCost = current.get(1);
                pq.add(new Pair(currentNeigh,currCost + currentEdgeCost));
            }
        }
        
        return costs; 
    }
}

