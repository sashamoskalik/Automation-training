package by.bsu.framework.model;

import java.util.Objects;
import java.util.Optional;

public class CarBook {
    private String placeFrom;
    private String userAge;

    public CarBook(String placeFrom, String userAge) {
        this.placeFrom = placeFrom;
        this.userAge = userAge;
    }

    public CarBook() {
    }

    public Optional<String> getPlaceFrom() {
        return Optional.ofNullable(placeFrom);
    }

    public CarBook setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
        return this;
    }

    public Optional<String> getUserAge() {
        return Optional.ofNullable(userAge);
    }

    public CarBook setUserAge(String userAge) {
        this.userAge = userAge;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBook carBook = (CarBook) o;
        return Objects.equals(placeFrom, carBook.placeFrom) &&
                Objects.equals(userAge, carBook.userAge);
    }

    @Override
    public int hashCode() {

        return Objects.hash(placeFrom, userAge);
    }

    @Override
    public String toString() {
        return "CarBook{" +
                "placeFrom='" + placeFrom + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
