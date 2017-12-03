
class Solution {

	public int findKthLargest(int[] nums, int k) {
		return findKth(nums, 0, nums.length - 1, nums.length - k);
	}

	private int findKth(int [] nums, int lo, int hi, int k) {
		if(lo == hi) {
			return nums[lo];
		}

		int p = partition(nums, lo, hi);

		if(p == k) {
			return nums[k];
		} else if(p > k) {
			return findKth(nums, lo, p - 1, k);
		} else {
			return findKth(nums, p + 1, hi, k);
		}
	}

	private int partition(int [] nums, int lo, int hi) {

		swap(nums, (int)(Math.random() * (hi - lo) + lo + 1), hi);

		int pivot = nums[hi], i = lo, j = hi;

		while(i < j) {
			if(nums[i++] > nums[j]) {
				swap(nums, --i, --j);
			}
		}

		swap(nums, i, hi);

		return i;
	}

	private void swap(int [] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
