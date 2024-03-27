package za.ac.cput.Factory;

import za.ac.cput.Domain.Author;
import za.ac.cput.util.helper;

//Author: Muneeb Solomons//
//Date: 26 March 2024//
public class AuthorFactory {
    public static Author buildAuthor() {
        return null;
    }

    public Author createAuthor(String name, String nationality, int birthYear) {
        if (helper.isNullorEmpty(name) || helper.isNullorEmpty(nationality))
            return null;

        return new Author.Builder().setName(name)
                .setNationality(nationality)
                .setBirthYear(birthYear)
                .build();


    }
}