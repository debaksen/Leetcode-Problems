class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        Set<Integer> recStack = new HashSet<>();
        
        for(int currVertex = 0; currVertex < V; currVertex++){
            if(!visited[currVertex] && dfs(currVertex,adj,recStack,visited)){
                return true;
            }
        }
        
        return false; 
    }
    
    private static boolean dfs(int currVertex, ArrayList<ArrayList<Integer>> adj, Set<Integer> stack, boolean[] visited){
       
        
        if(!stack.isEmpty() && stack.contains(currVertex)) return true; 
        
         if(visited[currVertex]) return false;
         
         visited[currVertex] = true;
         stack.add(currVertex);
         for(Integer currNeigh : adj.get(currVertex)){
             if(dfs(currNeigh,adj,stack,visited)) return true;
             
         }
         stack.remove(currVertex); 
         return false;
    }
}