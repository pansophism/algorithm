class Solution {

    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            left[i] = i;
            while (left[i] > 0 && heights[i] <= heights[left[i] - 1]) {
                left[i] = left[left[i] - 1];
            }
        }

        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            right[i] = i;
            while (right[i] < heights.length - 1 && heights[i] <= heights[right[i] + 1]) {
                right[i] = right[right[i] + 1];
            }
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            result= Math.max(result, heights[i] *(right[i] - left[i] + 1));
        }

        return result;
    }
}
