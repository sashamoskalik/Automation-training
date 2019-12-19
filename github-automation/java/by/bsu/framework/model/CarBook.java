package by.bsu.framework.model;

import org.apache.logging.log4j.LogManager;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

public class CarBook {

    private String placeFrom;
    private String placeTo;
    private String dateFrom;
    private String dateTo;
    private String userAge;

    public CarBook(String placeFrom, String placeTo, String dateFrom, String dateTo, String userAge) {
        this.placeFrom = placeFrom;
        this.placeTo = placeTo;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.userAge = userAge;
    }

    public CarBook() {
    }

    public Optional<String> getPlaceFrom() {
        return Optional.ofNullable(placeFrom);
    }

    public CarBook setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
        return null;
    }

    public Optional<String> getPlaceTo() {
        return Optional.ofNullable(placeTo);
    }

    public CarBook setPlaceTo(String placeTo) {
        this.placeTo = placeTo;
        return null;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
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
                Objects.equals(placeTo, carBook.placeTo) &&
                Objects.equals(dateFrom, carBook.dateFrom) &&
                Objects.equals(dateTo, carBook.dateTo) &&
                Objects.equals(userAge, carBook.userAge);
    }

    @Override
    public int hashCode() {

        return Objects.hash(placeFrom, placeTo, dateFrom, dateTo, userAge);
    }

    @Override
    public String toString() {
        return "CarBook{" +
                "placeFrom='" + placeFrom + '\'' +
                ", placeTo='" + placeTo + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
