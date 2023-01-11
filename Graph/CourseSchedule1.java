https://leetcode.com/problems/course-schedule/description/

class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {

       ArrayList<ArrayList<Integer>> adj = makeGraph(numCourses,edges);
       boolean[] visited = new boolean[numCourses];
       int index = 0;
       int[] inDegree = new int[numCourses]; 
       for(int currCourse =0; currCourse < numCourses; currCourse++){
           for(int currNeigh : adj.get(currCourse)){
               inDegree[currNeigh]+=1; 
           }
       }

       Queue<Integer> queue = new LinkedList<>();
       for(int ele=0; ele <numCourses; ele++){
           if(inDegree[ele] == 0)queue.add(ele);
       } 

       while(!queue.isEmpty()){
           int currCourse = queue.remove();

           if(!visited[currCourse]){
               visited[currCourse] = true;
               index++; // or we can maintain a arraylist to store the nodes
               for(int currNeigh : adj.get(currCourse)){
                   inDegree[currNeigh] -= 1; 
                   if(inDegree[currNeigh] == 0) queue.add(currNeigh);
               }
           }
       }

       if(index == numCourses) return true;
       return false; 
    }

    private ArrayList<ArrayList<Integer>> makeGraph(int numCourses, int[][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] currEdge : edges){
            graph.get(currEdge[1]).add(currEdge[0]);
        }

        return graph; 
    }
}