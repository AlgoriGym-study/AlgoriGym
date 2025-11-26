package D202511;

import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int len = banned_id.length;

        // 각 banned_id마다 매칭 가능한 user 인덱스 목록
        List<List<Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            for (int u = 0; u < user_id.length; u++) {
                if (isMatch(user_id[u], banned_id[i])) {
                    list.add(u);
                }
            }
            candidates.add(list);
        }

        // 조합을 문자열 키로 저장해서 중복 제거
        Set<String> cases = new HashSet<>();
        boolean[] used = new boolean[user_id.length];

        dfs(0, candidates, used, cases);

        return cases.size();
    }

    // idx번째 banned_id에 대해 어떤 user를 쓸지 정하는 DFS
    private void dfs(int idx,
                     List<List<Integer>> candidates,
                     boolean[] used,
                     Set<String> cases) {
        if (idx == candidates.size()) {
            // 사용된 user 인덱스를 순서대로 이어붙여 하나의 키로
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    sb.append(i).append(',');
                }
            }
            cases.add(sb.toString());
            return;
        }

        for (int userIdx : candidates.get(idx)) {
            if (used[userIdx]) continue;

            used[userIdx] = true;
            dfs(idx + 1, candidates, used, cases);
            used[userIdx] = false;
        }
    }

    private boolean isMatch(String user, String target) {
        if (user.length() != target.length()) return false;

        for (int j = 0; j < target.length(); j++) {
            char c = target.charAt(j);
            if (c == '*') continue;
            if (user.charAt(j) != c) return false;
        }
        return true;
    }
}
