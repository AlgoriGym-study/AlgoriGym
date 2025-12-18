package Algorithm_Study.daily.LYW;
import java.util.*;

public class D2025_12_18{
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            if (!genreTotal.containsKey(g)) {
                genreTotal.put(g, 0);
            }
            genreTotal.put(g, genreTotal.get(g) + p);

            if (!genreSongs.containsKey(g)) {
                genreSongs.put(g, new ArrayList<>());
            }
            genreSongs.get(g).add(new int[]{i, p});
        }

        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> result = new ArrayList<>();

        for (String g : genreOrder) {
            List<int[]> songs = genreSongs.get(g);
            songs.sort((s1, s2) -> {
                if (s1[1] != s2[1]) return s2[1] - s1[1]; 
                return s1[0] - s2[0]; 
            });

            result.add(songs.get(0)[0]);
            if (songs.size() >= 2) result.add(songs.get(1)[0]);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
