package ui;

import domein.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableApp {

    public ComparableApp() {
        List<Movie> list = new ArrayList<>();

        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Force Awakens", 8.3, 2010));
        list.add(new Movie("Force Awakens", 8.3, 2000));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        list.add(new Movie("Return of the Jedi", 8.4, 1999));
        list.add(new Movie("Return of the Jedi", 8.4, 2015));

        Collections.sort(list);

        System.out.println("Movies after sorting : ");
        for (Movie movie : list)
            System.out.println(movie);

    }
}
