package Algorithm_Study.daily.LYW;

public class D2026_01_19 {
    private String[] users;
    private String[] bans;

    private int[][] matchList;

    private boolean[] used;       
    private boolean[] seenMasks;  

    public int solution(String[] user_id, String[] banned_id) {
        this.users = user_id;
        this.bans = banned_id;

        int n = users.length;
        int m = bans.length;

        used = new boolean[n];
        seenMasks = new boolean[1 << n];

        matchList = new int[m][];
        for (int i = 0; i < m; i++) {
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

        dfs(0, 0); 

        int answer = 0;
        for (int mask = 0; mask < seenMasks.length; mask++) {
            if (seenMasks[mask]) answer++;
        }
        return answer;
    }

    private void dfs(int idx, int mask) {
        if (idx == bans.length) {
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
