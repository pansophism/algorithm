class Solution {

    public int numSquares(int n) {
        if(n <= 3) {
            return n;
        }

        int [] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                temp = Math.min(temp, arr[i - j * j] + 1);
            }

            arr[i] = temp;
        }

        return arr[n];
    }
}
