
class Solution {

	public List<String> addOperators(String num, int target) {

		List<String> ret = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return ret;
		}

		char[] digits = num.toCharArray();
		char[] path = new char[digits.length * 2 + 1];

		long n = 0;
		for (int i = 0; i < digits.length; i++) {
			n = n * 10 + (digits[i] - '0');
			path[i] = digits[i];
			dfs(ret, digits, i + 1, 0, n, path, i + 1, target);
			if (n == 0) break;
		}
		return ret;
	}

	private void dfs(List<String> ret, char[] digits, int loc, long left, long cur, char[] path, int pos, int target) {
		if (loc == digits.length) {
			if (left + cur == target) {
				ret.add(new String(path, 0, pos));
			}
			return;
		}

		long n = 0;
		int j = pos + 1;
		for (int i = loc; i < digits.length; i++){
			n = n * 10 + (digits[i] - '0');
			path[j++] = digits[i];

			path[pos] = '*';
			dfs(ret, digits, i + 1, left, cur * n, path, j, target);

			path[pos] = '+';
			dfs(ret, digits, i + 1, left + cur, n, path, j, target);

			path[pos] = '-';
			dfs(ret, digits, i + 1, left + cur, -1 * n, path, j, target);


			if (n == 0) break;
		}
	}
}
