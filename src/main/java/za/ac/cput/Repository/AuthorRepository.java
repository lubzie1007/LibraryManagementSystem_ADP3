package za.ac.cput.Repository;



import za.ac.cput.Domain.Author;

import java.util.ArrayList;
import java.util.List;
//Author: Muneeb Solomons//
//Date: 26 March 2024//
public class AuthorRepository implements iAuthorRepository {

    private static iAuthorRepository repository = null;

    private List<Author> authorList;

    private AuthorRepository() {authorList = new ArrayList<Author>();
    }

    public static iAuthorRepository getRepository() {
        if (repository == null) {
            repository = new AuthorRepository();
        }
        return repository;
    }


    @Override
    public Author create(Author author) {
        boolean success = authorList.add(author);
        if (success)
            return author;
        else
            return null;
    }

    @Override
    public Author read(String name) {
        for (Author e : authorList) {
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }

    @Override
    public Author update(Author author) {
        String name = author.getName();
        Author authorList = read(name);
        if (name == null)
            return null;
        if (delete(name)) {
            if (authorList.add(author))
                return author;
            return null;
        }
        return null;
    }

    @Override
    public boolean delete(String name) {
        Author authorToDelete = read(name);
        if (authorToDelete == null)
            return false;
        if (authorList.remove(authorToDelete)) {
            return true;
        }
        return false;
    }

    @Override
    public String getall() {
        return authorList.toString();

    }
}

