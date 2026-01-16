package programmers;

import java.util.*;

public class 베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        //총 재생수 추출 및 장르별 재생수 정리
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);

            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<int[]>());
            }
            genreSongs.get(genre).add(new int[]{i, play});
        }

        List<Integer> result = new ArrayList<>();

        int genreCount = genreTotal.size();

        for (int j = 0; j < genreCount; j++) {

            String bestGenre = "";
            int maxTotalPlay = -1;

            for (String genre : genreTotal.keySet()) {
                int total = genreTotal.get(genre);
                if (total > maxTotalPlay) {
                    maxTotalPlay = total;
                    bestGenre = genre;
                }
            }

            int firstId = -1, firstPlay = -1;
            int secondId = -1, secondPlay = -1;

            for (int[] song : genreSongs.get(bestGenre)) {
                int id = song[0];
                int play = song[1];

                if (play > firstPlay ||
                        (play == firstPlay && id < firstId)) {

                    secondPlay = firstPlay;
                    secondId = firstId;

                    firstPlay = play;
                    firstId = id;

                } else if (play > secondPlay ||
                        (play == secondPlay && id < secondId)) {

                    secondPlay = play;
                    secondId = id;
                }
            }

            result.add(firstId);
            if (secondId != -1) {
                result.add(secondId);
            }

            genreTotal.remove(bestGenre);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = 베스트앨범.solution(genres, plays);

        System.out.println(Arrays.toString(result));
    }
}