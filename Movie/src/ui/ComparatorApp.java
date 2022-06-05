package ui;

import domein.Movie;
import domein.RatingComparator;

import java.util.ArrayList;
import java.util.List;
//import domein.RatingComparator;

public class ComparatorApp {

    public ComparatorApp() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Sorteer Movie objecten op 'rating' :
        // (1) Instantieer een object RatingCompare
        // (2) Roep Collections.sort aan en geef dit
        // object mee als tweede parameter
        // (3) Print de gesorteerde lijst

        list.sort(new RatingComparator());

        System.out.println("Sorted by rating");
        for (Movie m : list)
            System.out.println(m);

    }

}
