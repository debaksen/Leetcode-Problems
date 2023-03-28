
https://leetcode.com/problems/network-delay-time/description/

class Pair implements Comparable<Pair>{
    int vertex;
    int signal;

    Pair(int vertex,int signal){
        this.vertex = vertex;
        this.signal = signal;
    }

    public int compareTo(Pair p){
       return this.signal - p.signal; 
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<ArrayList<Integer>>> graph = makeGraph(times,n);
        int[] costs = new int[n+1];
        Arrays.fill(costs,-1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair currNode = pq.remove();
            int vertex = currNode.vertex;
            int signal = currNode.signal; 

            if(costs[vertex] != -1) continue;

            costs[vertex] = signal; 
            ArrayList<ArrayList<Integer>> neighbours = graph.get(vertex);

            for(ArrayList<Integer> currNeigh : neighbours){
                int neighSignal = currNeigh.get(1);
                int neighVertex = currNeigh.get(0);
                pq.add(new Pair(neighVertex,signal+neighSignal));
            }
        }

        // min time for all node to receive signal
        int res = Integer.MIN_VALUE;
        for(int curr=1; curr<=n; curr++){
            if(costs[curr] == -1){
                res = -1;
                break; 
            }
            if(res < costs[curr]) res = costs[curr];
        }
        return res; 
    }

    private ArrayList<ArrayList<ArrayList<Integer>>> makeGraph(int[][] times, int n){
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<ArrayList<Integer>>());
        }

        for(int[] curr : times){
            int src = curr[0];
            int dest = curr[1];
            int time = curr[2];

            ArrayList<Integer> base = new ArrayList<>();
            base.add(dest);
            base.add(time);
            graph.get(src).add(base); 
        }

        return graph; 
    }
}