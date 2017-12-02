
class Solution {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }

        return select(nums, 0, nums.length - 1, nums.length - k);
    }

    private int select(int [] nums, int left, int right, int k) {
        if(left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if(pivotIndex == k) {
            return nums[pivotIndex];
        } else if(pivotIndex < k) {
            return select(nums, pivotIndex + 1, right, k);
        } else {
            return select(nums, left, pivotIndex - 1, k);
        }

    }

    private int partition(int [] nums, int left, int right) {

        int i = left, j = right, pivot = nums[right];

        while(i < j) {
            if(nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }

        swap(nums, i, right);

        return i;
    }

    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
