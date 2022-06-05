package domein;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        double r1 = o1.getRating();
        double r2 = o2.getRating();
        if (r1 == r2)
            return 0;
        return r1 > r2 ? -1 : 1;
    }

}
