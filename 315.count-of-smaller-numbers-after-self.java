public class Solution {

	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return new ArrayList<>();
		}

		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		for (int num : nums) {
			minVal = Math.min(minVal, num);
		}

		int[] nums2 = new int[n];

		for (int i = 0; i < n; i++) {
			nums2[i] = nums[i] - minVal + 1;
			maxVal = Math.max(nums2[i], maxVal);
		}

		int[] tree = new int[maxVal + 1];
		Integer[] ansArray = new Integer[n];

		for (int i = n - 1; i >= 0; i--) {
			ansArray[i] = get(nums2[i] - 1, tree);
			update(nums2[i], tree);
		}

		return Arrays.asList(ansArray);
	}
	private void update(int min, int[] tree) {
		for (int i = min; i < tree.length; i += (i & (-i))) {
			tree[i]++;
		}
	}

	private int get(int max, int[] tree) {
		int sum = 0;
		for (int i = max; i > 0; i -= (i & (-i))) {
			sum += tree[i];
		}
		return sum;
	}
}

