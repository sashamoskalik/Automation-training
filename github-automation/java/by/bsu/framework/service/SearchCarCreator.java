package by.bsu.framework.service;

import by.bsu.framework.model.SearchCar;

public class SearchCarCreator {

    private static final String DATA_TEST_10_MARK_CAR = "data.test10.mark-car";

    public static SearchCar markCar(){
        return (new SearchCar())
                .setMark(TestDataReader.getTestData(DATA_TEST_10_MARK_CAR));
    }
}
