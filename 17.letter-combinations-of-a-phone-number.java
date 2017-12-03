class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if(digits.length() > 0) {
            results.add("");
        }

        for(char c : digits.toCharArray()) {
            String letters = getLetters(c);
            List<String> newResults = new ArrayList<>();

            for(char c1 : letters.toCharArray()) {
                for(String s : results) {
                    newResults.add(s + " " + c1);
                }
            }

            results = newResults;
        }

        return results;
    }

    private String getLetters(char d) {
        switch(d) {
            case '0':
                return " ";
            case '1':
                return "N/A";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                throw new IllegalArgumentException("are you kidding me?");
        }
    }

}
