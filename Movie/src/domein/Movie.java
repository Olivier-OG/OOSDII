package domein;

public class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    // Constructor
    public Movie(String nm, double rt, int yr) {
        setName(nm);
        setRating(rt);
        setYear(yr);
    }

    // Getter & setter methods for accessing private data
    public double getRating() {
        return rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", getName(), getRating(), getYear());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return year == other.year;
    }

    @Override
    public int compareTo(Movie m) {
        int result = name.compareTo(m.getName());
        if (result != 0)
            return result;
        return year - m.getYear();
    }

}