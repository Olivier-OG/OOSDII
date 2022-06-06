package ui;

import domein.Movie;
import domein.RatingComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//import domein.RatingComparator;

public class ComparatorApp {

    private final List<Movie> list;

    public ComparatorApp() {
        list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Comparator Interface
        list.sort(new RatingComparator());
        printList();

        // Anonymous Inner Class
        list.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Double.compare(o1.getRating(), o2.getRating());
            }
        });
        printList();

        // Lambda Expression
        list.sort((o1, o2) -> Double.compare(o1.getRating(), o2.getRating()));
        printList();

        // Method Reference
        list.sort(Movie::compareRating);
        printList();

    }

    private void printList() {
        System.out.println("Sorted by rating");
        for (Movie m : list)
            System.out.println(m);
    }

}
