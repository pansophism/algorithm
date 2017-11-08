class Solution {

    public int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int [] hi = new int[matrix[0].length + 1];

        int max = 0;

        for(int r = 0; r < matrix.length; r++) {
            char [] row = matrix[r];

            for(int c = 0; c < row.length; c++) {
                if(row[c] == '1') {
                    hi[c] += 1;
                } else {
                    hi[c] = 0;
                }
            }

            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i <= row.length; i++) {
                if(stack.isEmpty() || hi[i] >= hi[stack.peek()]) {
                    stack.push(i);
                } else {
                    while(!stack.isEmpty() && hi[stack.peek()] > hi[i]) {
                        int top = stack.pop();
                        int area = hi[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                        max = Math.max(max, area);
                    }
                    stack.push(i);
                }
            }

        }

        return max;
    }
}
