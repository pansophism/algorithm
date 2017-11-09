class Solution {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;

        for(int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);

            if(stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int pre = stack.pop();
                area = Math.max(area,
                        heights[pre] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;

            }
        }

        return area;

    }
}
