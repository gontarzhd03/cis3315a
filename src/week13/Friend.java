package week13;

import java.util.Objects;

/**
 *
 * @author 55jphillip
 */
public class Friend implements Comparable<Friend> {

    private String name;
    private int rating;

    public Friend(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Friend)) return false;
        Friend friend = (Friend) o;
//        return this.name.equals(friend.getName());
        return rating == friend.getRating() && Objects.equals(name, friend.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Friend f) {
        return Integer.compare(this.rating, f.rating);
        //return this.rating - f.rating;
    }

    @Override
    public String toString() {
        return name + ":" + rating;
    }
}
