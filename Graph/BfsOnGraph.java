https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[V]; 
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()){
            int currentVertex = queue.remove();
            
            if(visited[currentVertex])
            continue; 
            
            visited[currentVertex] = true;
            answer.add(currentVertex); 
            
            for(int currentNeigh : adj.get(currentVertex)){
                queue.add(currentNeigh);
            }
        }
        return answer; 
    }
}