package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map<String, Genre> genreMap = new HashMap<>();
        for (Entry<String, Integer> entry : genrePlayCount.entrySet()) {
            genreMap.put(entry.getKey(), new Genre(entry.getKey(), entry.getValue()));
        }

        PriorityQueue<Song> bestAlbum = new PriorityQueue<>();
        for (int i = 0; i < genres.length; i++) {
            bestAlbum.add(new Song(i, genreMap.get(genres[i]), plays[i]));
        }

        List<Integer> songs = new ArrayList<>();
        String genre = "";
        int count = 0;
        while (!bestAlbum.isEmpty()) {
            Song song = bestAlbum.poll();
            if (genre.equals(song.genre.name)) {
                count++;
                if (count <= 2) songs.add(song.id);
            } else {
                genre = song.genre.name;
                count = 1;
                songs.add(song.id);
            }
        }

        return songs.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        베스트앨범 sol = new 베스트앨범();
        System.out.println(Arrays.toString(sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
            new int[]{500, 600, 150, 800, 2500}))); // [4, 1, 3, 0]
    }
}

class Genre implements Comparable<Genre> {
    String name;
    int plays;

    public Genre(String name, int plays) {
        this.name = name;
        this.plays = plays;
    }

    @Override
    public int compareTo(Genre other) {
        return other.plays - this.plays;
    }
}

class Song implements Comparable<Song> {
    int id;
    Genre genre;
    int plays;

    public Song(int id, Genre genre, int plays) {
        this.id = id;
        this.genre = genre;
        this.plays = plays;
    }

    @Override
    public int compareTo(Song other) {
        if (this.genre.equals(other.genre)) {
            if (this.plays == other.plays) {
                return this.id - other.id;
            }
            return other.plays - this.plays;
        }
        return this.genre.compareTo(other.genre);
    }
}