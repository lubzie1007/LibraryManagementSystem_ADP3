package za.ac.cput.Domain;

/*
Genre class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */

public class Genre {
    private final String name;
    private final String description;

    private Genre(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String name;
        private String description;

        public Builder(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public Genre build() {
            return new Genre(this);
        }
    }
}