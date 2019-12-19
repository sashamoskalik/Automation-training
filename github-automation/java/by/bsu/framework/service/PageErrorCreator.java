package by.bsu.framework.service;

import by.bsu.framework.model.PageError;

public class PageErrorCreator {
    private static final String DATA_TEST_2_ERROR_MESSAGE = "data.test2.error.message";
    private static final String DATA_TEST_1_ERROR_MESSAGE = "data.test1.error.message";
    private static final String DATA_TEST_3_ERROR_MESSAGE = "data.test3.error.message";
    private static final String DATA_TEST_4_ERROR_MESSAGE = "data.test4.error.message";
    private static final String DATA_TEST_5_ERROR_MESSAGE = "data.test5.error.message";
    private static final String DATA_TEST_6_ERROR_MESSAGE = "data.test6.error.message";
    private static final String DATA_TEST_7_ERROR_MESSAGE = "data.test7.error.message";
    private static final String DATA_TEST_8_ERROR_MESSAGE = "data.test8.error.message";
    private static final String DATA_TEST_9_ERROR_MESSAGE = "data.test9.error.message";
    private static final String DATA_TEST_10_ERROR_MESSAGE = "data.test10.error.message";

    public static PageError errorWithoutChoosingplaceFromTheList() {
        return new PageError(TestDataReader.getTestData(DATA_TEST_2_ERROR_MESSAGE));
    }

    public static PageError errorYoungUser() {
        return new PageError(TestDataReader.getTestData(DATA_TEST_1_ERROR_MESSAGE));
    }

    public static PageError accessRegistrationCar(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_4_ERROR_MESSAGE));
    }

    public static PageError errorDateTo(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_3_ERROR_MESSAGE));
    }

    public static PageError errorEmail(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_5_ERROR_MESSAGE));
    }

    public static PageError errorPriceFilter(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_6_ERROR_MESSAGE));
    }

    public static PageError errorChangeCurrency(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_7_ERROR_MESSAGE));
    }

    public static PageError errorDropOffInAnotherLocation(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_8_ERROR_MESSAGE));
    }

    public static PageError errorBigDateTo(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_9_ERROR_MESSAGE));
    }

    public static PageError errorSearchCar(){
        return new PageError(TestDataReader.getTestData(DATA_TEST_10_ERROR_MESSAGE));
    }
}