class Solution {

    public int largestRectangleArea(int[] heights) {

        int max = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int top = stack.pop();
                    int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() + 1);
                    max = Math.max(area, max);
                }

                stack.push(i);
            }
        }

        return max;
    }
}
