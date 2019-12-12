package by.bsu.framework.service;

import by.bsu.framework.model.CarBook;

public class CarReservationCreator {

    private static final String DATA_TEST_1_AGE = "data.test1.age";
    private static final String DATA_TEST_2_PLACE_FROM = "data.test2.place-from";

    public static CarBook withoutChoosingPlaceFromTheList() {
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_2_PLACE_FROM));
    }

    public static CarBook youngUser(){
        return (new CarBook())
                .setUserAge(TestDataReader.getTestData(DATA_TEST_1_AGE));
    }
}
