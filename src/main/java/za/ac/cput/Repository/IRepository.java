package za.ac.cput.Repository;

import za.ac.cput.Domain.Library;

import java.util.List;

public interface IRepository {
    void saveLibrary(Library library);
    void updateLibrary(Library library);
    void deleteLibrary(int id);
    Library getLibraryById(int id);
    List<Library> getAllLibraries();
}
