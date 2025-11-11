package Algorithm_Study.daily.PJE.D202511;
import java.util.*;

public class D20251111{
    public int[] solution(String[] genres, int[] plays) {
        // 1) 장르별 총 재생수
        Map<String, Integer> genreTotal = new HashMap<>();
        // 2) 장르별 노래 목록 (id, 재생수)
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            // 장르별 총합
            if (!genreTotal.containsKey(g)) {
                genreTotal.put(g, 0);
            }
            genreTotal.put(g, genreTotal.get(g) + p);

            // 장르별 노래 리스트 만들기
            if (!genreSongs.containsKey(g)) {
                genreSongs.put(g, new ArrayList<>());
            }
            genreSongs.get(g).add(new int[]{i, p});
        }

        // 3) 장르를 총 재생수 많은 순으로 정렬
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> result = new ArrayList<>();

        // 4) 각 장르 안에서 정렬 (재생수↓, 번호↑)
        for (String g : genreOrder) {
            List<int[]> songs = genreSongs.get(g);
            songs.sort((s1, s2) -> {
                if (s1[1] != s2[1]) return s2[1] - s1[1]; // 재생수 높은 순
                return s1[0] - s2[0]; // 재생수가 같으면 id 낮은 순
            });

            // 5) 상위 최대 2곡만 선택
            result.add(songs.get(0)[0]);
            if (songs.size() >= 2) result.add(songs.get(1)[0]);
        }

        // 6) ArrayList → int 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
