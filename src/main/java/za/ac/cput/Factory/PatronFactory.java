package za.ac.cput.Factory;

import za.ac.cput.Domain.Patron;
// Ronewa Khashane
// 219398208
public class PatronFactory {

    public static Patron createPatron(int id, String name, String address, String email) {
        return new Patron.Builder(id, name)
                .address(address)
                .email(email)
                .build();
    }
}

