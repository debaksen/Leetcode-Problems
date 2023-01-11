// Kahn's Algorithm to check for cycles in graph 
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V+1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        for(int currVertex = 0;currVertex < V; currVertex++){
            for(int curr : adj.get(currVertex))
            inDegree[curr] +=1; 
        }
        
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int currVertex = queue.remove();
            
            if(visited[currVertex]) continue; 
            
            visited[currVertex] = true; 
            List<Integer> neighbours = adj.get(currVertex);
            for(int currNeigh : neighbours){
                inDegree[currNeigh] -= 1; 
                if(inDegree[currNeigh]== 0){
                    queue.add(currNeigh);
                }
            }
        }
        
        for(boolean curr : visited){
            
            if(curr == false) return true;
        }
        
        return false; 
        
    }
}