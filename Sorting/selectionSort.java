class Solution {
  public int[] sortArray(int[] nums) {

    // Selection Sort O(n2)

    for (int i = 0; i < nums.length - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[minIdx])
          minIdx = j;
      }

      swap(nums, minIdx, i);
    }

    return nums;

  }

  public static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
}