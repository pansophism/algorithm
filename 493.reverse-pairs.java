
public class Solution {

	public int reversePairs(int[] nums) {
		int [] temp = new int[nums.length];

		return countAndMergeSort(nums, temp, 0, nums.length - 1);
	}

	private int countOnly(int [] nums, int lo, int mid, int hi) {
		int ans = 0, count = 0;

		for(int i = lo, j = mid + 1; i <= mid;) {
			if(j > hi || (long)nums[i] <= (long)(2 * nums[j])) {
				i++;
				ans += count;
			} else {
				j++;
				count++;
			}
		}

		return ans;
	}

	private int countAndMergeSort(int [] nums, int [] temp, int lo, int hi) {
		if(lo >= hi) {
			return 0;
		}

		int mid = lo + (hi - lo) / 2;

		int lCount = countAndMergeSort(nums, temp, lo, mid);
		int rCount = countAndMergeSort(nums, temp, mid + 1, hi);

		// count
		int count = countOnly(nums, lo, mid, hi);

		// merge
		int i = lo, j = mid + 1, k = lo;
		while(i <= mid && j <= hi) {
			if(nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		while(i <= mid) {
			temp[k++] = nums[i++];
		}

		while(j <= hi) {
			temp[k++] = nums[j++];
		}

		for(int a = lo; a <= hi; a++) {
			nums[a] = temp[a];
		}

		return lCount + count + rCount;
	}

}
