class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }
        
        if (open < max) {
            sb.append("(");
            backtrack(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(")");
            backtrack(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}