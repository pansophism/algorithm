class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, n - k + 1);
    }

    private void swap(int [] nums, int from, int to) {
        int t = nums[from];
        nums[from] = nums[to];
        nums[to] = from;
    }

    private int findKthLargest(int [] nums, int start, int end, int k) {

        int i = start, j = end;

        while(i < j) {
            if(nums[i] >= nums[end]) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        swap(nums, i, end);

        int m = i - start + 1;

        if(m == k) {
            return i;
        } else if(m > k) {
            return findKthLargest(nums, start, i - 1, k);
        } else {
            return findKthLargest(nums, i + 1, end, k - m);
        }
    }
}

