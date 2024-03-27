package za.ac.cput.Repository;

import za.ac.cput.Domain.Genre;

import java.util.List;

/*
GenreRepository class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */

public interface GenreRepository {
    void saveGenre(Genre genre);
    Genre findGenreByName(String name);
    void deleteGenre(String name);
    List<Genre> getAllGenres();
}
