package za.ac.cput.Factory;

import za.ac.cput.Domain.Genre;

/*
GenreTest class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */

public class GenreFactory {
    public Genre createGenre(String name, String description) {
        return new Genre.Builder(name, description).build();
    }
}
