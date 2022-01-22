import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {
    public static Map<String, List<String>> favGenres(Map<String, List<String>> userMap,
            Map<String, List<String>> genreMap) {
        Map<String, List<String>> favoriteGenres = new HashMap<>();
        Map<String, String> videoToGenre = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> videos = genreMap.get(genre);

            for (String video : videos) {
                videoToGenre.put(video, genre);
            }
        }

        for (String user : userMap.keySet()) {
            List<String> videos = userMap.get(user);
            Map<String, Integer> genreCount = new HashMap<>();

            for (String video : videos) {
                for (String genre : genreMap.keySet()) {
                    if (videoToGenre.get(video).equals(genre)) {
                        genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
                    }
                }
            }

            int maxValue = 0;
            if(genreCount.size() == 0)
                favoriteGenres.put(user, new ArrayList<>());

            for (String genre : genreCount.keySet()) {
                int count = genreCount.get(genre);

                if (count > maxValue) {
                    List<String> genres = new ArrayList<String>();
                    genres.add(genre);
                    favoriteGenres.put(user, genres);
                    maxValue = count;
                }

                else if (count == maxValue) {
                    List<String> genres = favoriteGenres.getOrDefault(user, new ArrayList<String>());
                    genres.add(genre);
                    favoriteGenres.put(user, genres);
                }
            }
        }

        return favoriteGenres;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        userMap.put("David", new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
        userMap.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));

        Map<String, List<String>> genreMap = new HashMap<>();
        genreMap.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song3")));
        genreMap.put("Dubstep", new ArrayList<String>(Arrays.asList("song7")));
        genreMap.put("Techno", new ArrayList<String>(Arrays.asList("song2", "song4")));
        genreMap.put("Pop", new ArrayList<String>(Arrays.asList("song5", "song6")));
        genreMap.put("Jazz", new ArrayList<String>(Arrays.asList("song8", "song9")));

        Map<String, List<String>> res = favGenres(userMap, genreMap);

        for (String usern : res.keySet()) {
            System.out.println(usern);
            List<String> favgen = res.get(usern);
            System.out.println(favgen);
        }
    }
}