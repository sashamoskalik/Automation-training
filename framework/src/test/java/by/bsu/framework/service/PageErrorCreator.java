package by.bsu.framework.service;

import by.bsu.framework.model.PageError;

public class PageErrorCreator {
    private static final String DATA_TEST_2_ERROR_MESSAGE = "data.test2.error.message";
    private static final String DATA_TEST_1_ERROR_MESSAGE = "data.test1.error.message";

    public static PageError errorWithoutChoosingplaceFromTheList() {
        return new PageError(TestDataReader.getTestData(DATA_TEST_2_ERROR_MESSAGE));
    }

    public static PageError errorYoungUser() {
        return new PageError(TestDataReader.getTestData(DATA_TEST_1_ERROR_MESSAGE));
    }
}