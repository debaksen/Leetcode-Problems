class Solution {
  public int[] sortArray(int[] nums) {

    // Bubble Sort O(n2) Input Dependent

    int n = nums.length;
    for (int times = 0; times < n - 1; times++) {
      Boolean swapFlag = false;
      for (int j = 0; j < n - times - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
          swapFlag = true;
        }
      }
      if (swapFlag == false)
        break;
    }
    return nums;
  }

  public static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
}