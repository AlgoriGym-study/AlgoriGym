package Algorithm_Study.daily.YHS;

import java.util.*;

public class D20250501_단축키지정 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2) -> map.get(o2) - map.get(o1));

        List<Song> songList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String genre = list.get(i);

            for (int j = 0; j < genres.length; j++) {

            }
        }
    }

    static class Song implements Comparable<Song> {
        String genre;
        int play;

        public Song(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            return this.play - o.play;
        }
    }
}
