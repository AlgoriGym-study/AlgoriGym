package Algorithm_Study.daily.LYW;

public class D2025_12_24 {
    // 입력
    private String[] users;
    private String[] bans;

    // 각 banned_id가 매칭 가능한 user 인덱스 목록 (전처리)
    private int[][] matchList;

    // 방문/기록
    private boolean[] used;        // 현재 백트래킹에서 고른 사용자
    private boolean[] seenMasks;   // 완성된 조합(mask)을 중복 없이 기록 (크기 1<<users.length)

    public int solution(String[] user_id, String[] banned_id) {
        this.users = user_id;
        this.bans = banned_id;

        int n = users.length;
        int m = bans.length;

        used = new boolean[n];
        seenMasks = new boolean[1 << n];

        // 전처리: 각 banned 패턴에 대해 매칭되는 user 인덱스 묶기
        matchList = new int[m][];
        for (int i = 0; i < m; i++) {
            // 일단 가능한 후보를 임시 배열에 모은 후 정확한 크기의 배열로 복사
            int[] tmp = new int[n];
            int cnt = 0;
            for (int u = 0; u < n; u++) {
                if (isMatch(users[u], bans[i])) {
                    tmp[cnt++] = u;
                }
            }
            int[] list = new int[cnt];
            for (int k = 0; k < cnt; k++) list[k] = tmp[k];
            matchList[i] = list;
        }

        dfs(0, 0); // banned 인덱스 0부터, 현재 bitmask = 0

        // seenMasks에 true로 표시된 조합 수가 정답
        int answer = 0;
        for (int mask = 0; mask < seenMasks.length; mask++) {
            if (seenMasks[mask]) answer++;
        }
        return answer;
    }

    // 백트래킹: idx번째 banned_id에 대해 매칭 가능한 user를 하나 고르고 진행
    private void dfs(int idx, int mask) {
        if (idx == bans.length) {
            // 하나의 완성된 조합 도달
            seenMasks[mask] = true;
            return;
        }

        int[] candidates = matchList[idx];
        for (int i = 0; i < candidates.length; i++) {
            int u = candidates[i];
            if (!used[u]) {
                used[u] = true;
                dfs(idx + 1, mask | (1 << u));
                used[u] = false;
            }
        }
    }

    // user가 ban 패턴에 매칭되는지 체크
    private boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            char bc = ban.charAt(i);
            if (bc == '*') continue;
            if (bc != user.charAt(i)) return false;
        }
        return true;
    }
}
