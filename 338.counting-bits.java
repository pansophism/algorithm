class Solution {

    public int[] countBits(int num) {

        int [] arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= num; i++) {
            arr[i] = arr[i / 2] + (i & 1);
        }

        return arr;
    }

}
