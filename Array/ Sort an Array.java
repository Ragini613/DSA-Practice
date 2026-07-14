class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        int[] result = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            result[k++] = nums[i++];
        }

        while (j <= high) {
            result[k++] = nums[j++];
        }

        for (int p = 0; p < result.length; p++) {
            nums[low + p] = result[p];
        }
    }
}