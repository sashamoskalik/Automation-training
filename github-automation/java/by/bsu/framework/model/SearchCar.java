package by.bsu.framework.model;

import java.util.Objects;
import java.util.Optional;

public class SearchCar {

    private String mark;

    public SearchCar(){}

    public SearchCar(String mark) {
        this.mark = mark;
    }

    public Optional<String> getMark() {
        return Optional.ofNullable(mark);
    }

    public SearchCar setMark(String mark) {
        this.mark = mark;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCar searchCar = (SearchCar) o;
        return Objects.equals(mark, searchCar.mark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mark);
    }

    @Override
    public String toString() {
        return "SearchCar{" +
                "mark='" + mark + '\'' +
                '}';
    }
}
