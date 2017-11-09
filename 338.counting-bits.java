class Solution {

    public int[] countBits(int num) {

        int [] arr = new int[num + 1];
        arr[0] = 0;

        for(int i = 1; i <= num; i++) {
            arr[i] = arr[i / 2] + (i & 1);
        }

        return arr;
    }

}
