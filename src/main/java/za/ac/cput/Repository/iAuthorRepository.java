package za.ac.cput.Repository;

import za.ac.cput.Domain.Author;

public interface iAuthorRepository {


    Author create(Author author);

    Author read(String name);

    Author update(Author author);

    boolean delete(String name);

    String getall();

    public interface IAuthorRepository extends IRepositoryAuthor<Author, String> {

        String getall();
    }

}
//Author: Muneeb Solomons//
//Date: 26 March 2024//