class Solution {
  public int trap(int[] height) {

    int maxLeft = Integer.MIN_VALUE;
    int maxRight = Integer.MIN_VALUE;
    int waterLevel = 0;

    int[] left = new int[height.length];
    int[] right = new int[height.length];

    for (int i = 0; i < height.length; i++) {
      if (height[i] > maxLeft)
        maxLeft = height[i];
      left[i] = maxLeft;
    }

    for (int i = height.length - 1; i >= 0; i--) {
      if (height[i] > maxRight)
        maxRight = height[i];
      right[i] = maxRight;
    }

    for (int i = 0; i < height.length; i++) {
      int currWater = Math.min(left[i], right[i]) - height[i];
      waterLevel += currWater;
    }

    return waterLevel;

  }
}