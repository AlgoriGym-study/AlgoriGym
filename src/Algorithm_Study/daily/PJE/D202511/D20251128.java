package Algorithm_Study.daily.PJE.D202511;
import java.util.*;

public class D20251128 {
  
    boolean[] visited;
    // 최종 결과 조합들을 저장
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        visited = new boolean[user_id.length];

        // 0번째 banned_id부터 매칭 시작
        dfs(0, user_id, banned_id, new HashSet<>());

        return result.size();
    }

    /**
     * idx : 현재 매칭하려는 banned_id의 인덱스
     * current : 현재까지 매칭된 user들의 집합
     */
    void dfs(int idx, String[] user_id, String[] banned_id, Set<String> current) {

        // banned_id를 전부 매칭한 경우 → 하나의 조합 완성
        if (idx == banned_id.length) {
            result.add(new HashSet<>(current));   // 집합 형태 그대로 저장 (순서 무시)
            return;
        }

        String pattern = banned_id[idx];

        // 현재 패턴에 매칭 가능한 모든 user 검사
        for (int i = 0; i < user_id.length; i++) {

            // 이미 이전 패턴에서 사용한 user는 제외
            if (visited[i]) continue;

            // 패턴이랑 매치 안되면 패스
            if (!isMatch(user_id[i], pattern)) continue;

            // user 사용 체크
            visited[i] = true;
            current.add(user_id[i]);

            // 다음 banned_id 인덱스로 이동
            dfs(idx + 1, user_id, banned_id, current);

            // 백트래킹 (원상복구)
            visited[i] = false;
            current.remove(user_id[i]);
        }
    }

    /**
     * user_id 하나가 banned_id 패턴과 매칭되는지 검사
     * - 길이가 다르면 false
     * - '*'은 어떤 글자와도 매칭됨
     */
    boolean isMatch(String user, String pattern) {

        if (user.length() != pattern.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            char pc = pattern.charAt(i);

            if (pc == '*') continue;    
            if (pc != user.charAt(i)) return false;
        }

        return true;
    }
}
