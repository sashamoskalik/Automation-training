package by.bsu.framework.service;

import by.bsu.framework.model.CarBook;

public class CarReservationCreator {

    private static final String DATA_TEST_1_AGE = "data.test1.age";
    private static final String DATA_TEST_2_PLACE_FROM = "data.test2.place-from";
    private static final String DATA_TEST_4_PLACE_FROM="data.test4.place-from";
    private static final String DATA_TEST_6_PLACE_FROM = "data.test6.place-from";
    private static final String DATA_TEST_7_PLACE_FROM = "data.test7.place-from";
    private static final String DATA_TEST_8_PLACE_FROM = "data.test8.place-from";
    private static final String DATA_TEST_8_PLACE_TO = "data.test8.place-to";
    private static final String DATA_TEST_9_PLACE_FROM = "data.test9.place-from";
    private static final String DATA_TEST_10_PLACE_FROM = "data.test10.place-from";



    public static CarBook withoutChoosingPlaceFromTheList() {
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_2_PLACE_FROM));
    }

    public static CarBook youngUser(){
        return (new CarBook())
                .setUserAge(TestDataReader.getTestData(DATA_TEST_1_AGE));
    }

    public static CarBook bookingCar(){
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_4_PLACE_FROM));
    }

    public static CarBook bookingCarForPriceFilter(){
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_6_PLACE_FROM));
    }

    public static CarBook bookingCarForChangeCurrency(){
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_7_PLACE_FROM));
    }

    public static CarBook bookingCarForDropOffInAnotherLocation(){
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_8_PLACE_FROM))
                .setPlaceTo(TestDataReader.getTestData(DATA_TEST_8_PLACE_TO));
    }

    public static CarBook bookingCarForBigDateTo(){
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_9_PLACE_FROM));
    }

    public static CarBook bookingCarForSearchCar(){
        return (new CarBook())
                .setPlaceFrom(TestDataReader.getTestData(DATA_TEST_10_PLACE_FROM));
    }
}
