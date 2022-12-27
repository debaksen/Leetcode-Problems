// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[V]; 
        depthFirstSearch(adj,0,visited,answer);
        return answer; 
    }
    
    private void depthFirstSearch(ArrayList<ArrayList<Integer>> adj, int currVertex,boolean[] visited, ArrayList<Integer> answer){
        if(visited[currVertex]) return; 
        
        visited[currVertex] = true; 
        answer.add(currVertex);
        List<Integer> neighbours = adj.get(currVertex);
        for(int currEle : neighbours){
            depthFirstSearch(adj,currEle,visited,answer);
        }
    }
}