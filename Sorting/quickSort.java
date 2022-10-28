class Solution {

  // quickSort O(NlogN)
  public int[] sortArray(int[] nums) {

    int lo = 0;
    int hi = nums.length - 1;
    quickSort(nums, lo, hi);
    return nums;
  }

  public static void quickSort(int[] arr, int lo, int hi) {
    if (lo > hi)
      return;

    int pivot = arr[hi];

    int pivIdx = partition(arr, lo, hi, pivot);
    quickSort(arr, lo, pivIdx - 1);
    quickSort(arr, pivIdx + 1, hi);

  }

  public static int partition(int[] arr, int lo, int hi, int pivot) {

    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] > pivot) {
        i++;
      } else {
        swap(arr, i, j);
        i++;
        j++;
      }
    }

    int pivIdx = j - 1;
    return pivIdx;
  }

  public static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
}
