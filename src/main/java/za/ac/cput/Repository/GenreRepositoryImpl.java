package za.ac.cput.Repository;

import za.ac.cput.Domain.Genre;

import java.util.HashMap;
import java.util.Map;

public class GenreRepositoryImpl {
    private static final Map<String, Genre> genreMap = new HashMap<>();

    // Create or Update a genre
    public void saveGenre(Genre genre) {
        genreMap.put(genre.getName(), genre);
    }

    // Retrieve a genre by name
    public Genre findGenreByName(String name) {
        return genreMap.get(name);
    }

    // Delete a genre by name
    public void deleteGenre(String name) {
        genreMap.remove(name);
    }

    // Retrieve all genres
    public Map<String, Genre> getAllGenres() {
        return genreMap;
    }
}
