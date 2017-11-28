import java.util.*;

class Solution {
    private HashMap<String, List<Integer>> hm = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if(hm.containsKey(input)) {
            return hm.get(input);
        }

        List<Integer> res = new LinkedList<>();

        for(int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+') {

                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);

                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);

                for(Integer p1 : part1Ret) {
                    for(Integer p2 : part2Ret) {
                        int c = 0;

                        switch(input.charAt(i)) {
                            case '+': c = p1 + p2; break;
                            case '-': c = p1 - p2; break;
                            case '*': c = p1 * p2; break;
                        }

                        res.add(c);

                    }
                }

            }
        }

        if(res.size() == 0) {
            res.add(Integer.valueOf(input));
        }

        hm.add(input, res);

        return res;

    }
}
