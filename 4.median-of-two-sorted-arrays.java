class Solution {

	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int l = m + n;
		if (l % 2 == 0) {
			return (getKth(A, 0, B, 0, (l - 1) / 2 + 1)
					+ getKth(A, 0, B, 0, l/2 + 1)) / 2.0;
		} else {
			return getKth(A, 0, B, 0, (l - 1) / 2 + 1);
		}
	}

	public int getKth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart >= A.length) {
			return B[bStart + k - 1];
		}
		if (bStart >= B.length) {
			return A[aStart + k - 1];
		}
		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}
		int amid = aStart + k / 2 - 1 >= A.length
			? Integer.MAX_VALUE : A[aStart + k / 2 - 1];

		int bmid = bStart + k / 2 - 1 >= B.length
			? Integer.MAX_VALUE : B[bStart + k / 2 - 1];

		if (amid > bmid) {
			return getKth(A, aStart, B, bStart + k / 2, k - k / 2);
		} else {
			return getKth(A, aStart + k / 2, B, bStart, k - k / 2);
		}
	}

}
