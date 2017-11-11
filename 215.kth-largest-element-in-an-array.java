class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private void swap(int [] nums, int from, int to) {
        int t = nums[from];
        nums[from] = nums[to];
        nums[to] = from;
    }

    private int findKthLargest(int [] nums, int start, int end, int k) {
        if(k == 0) {
            return nums[start - 1];
        }

        int i = start, j = end - 1;

        while(i < j) {
            if(nums[i] >= nums[end]) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        swap(nums, i, end);

        if(i > k) {
            return findKthLargest(nums, start, i - 1, k);
        } else {
            return findKthLargest(nums, i + 1, end, k - (i - start + 1));
        }
    }
}

