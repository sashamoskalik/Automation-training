package by.bsu.framework.service;

import by.bsu.framework.model.EnterAccount;

public class LoginCreator {

    private static final String DATA_TEST_5_EMAIL = "data.test5.email";

    public static EnterAccount errorEmail(){
        return (new EnterAccount())
                .setEmail(TestDataReader.getTestData(DATA_TEST_5_EMAIL));
    }
}
