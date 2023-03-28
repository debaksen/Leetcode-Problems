// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] cost = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) cost[i][j] = 0;

                else cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] curr : edges){
            int source = curr[0];
            int dest = curr[1];
            int distance = curr[2];

            cost[source][dest] = distance;
            cost[dest][source] = distance;
        }

        for(int interval =0;interval<n;interval++){
            for(int source=0;source<n;source++ ){
                for(int destination=0;destination<n;destination++){

                    if(cost[source][interval] != Integer.MAX_VALUE && cost[interval][destination] != Integer.MAX_VALUE){
                        cost[source][destination] = Math.min(cost[source][destination],cost[source][interval]+cost[interval][destination]);
                    }
                }
            }
        }


        int minReach = Integer.MAX_VALUE;
        int minReachIdx = n; 
        for(int i=0;i<n;i++){
            int cityReach = 0;
            for(int j=0;j<n;j++){
                if(cost[i][j] <= distanceThreshold) cityReach++; 
            }
            if(cityReach <= minReach){
                minReach = cityReach;
                minReachIdx = i; 
            }
        }

        return minReachIdx; 
    }
}