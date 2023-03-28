class Solution {
  public int findCheapestPrice(int n, int[][] flights, int isrc, int dst, int k) {

    int[] costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);

    costs[isrc] = 0;

    for (int i = 0; i < k + 1; i++) {

      System.out.println(Arrays.toString(costs));
      int[] temp = Arrays.copyOf(costs, n);
      for (int[] currFlight : flights) {
        int src = currFlight[0];
        int dest = currFlight[1];
        int price = currFlight[2];

        if (costs[src] != Integer.MAX_VALUE) {
          temp[dest] = Math.min(temp[dest], costs[src] + price);
        }
      }

      costs = temp;
    }

    return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];

  }
}