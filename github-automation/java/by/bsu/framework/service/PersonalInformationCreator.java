package by.bsu.framework.service;

import by.bsu.framework.model.PersonalInformation;

public class PersonalInformationCreator {

    private static final String DATA_TEST_4_NAME="data.test4.name";
    private static final String DATA_TEST_4_SURNAME="data.test4.surname";
    private static final String DATA_TEST_4_EMAIL="data.test4.email";
    private static final String DATA_TEST_4_PHONE="data.test4.phone";

    public static PersonalInformation personalInformation(){
        return (new PersonalInformation())
                .setName(TestDataReader.getTestData(DATA_TEST_4_NAME))
                .setSurname(TestDataReader.getTestData(DATA_TEST_4_SURNAME))
                .setEmail(TestDataReader.getTestData(DATA_TEST_4_EMAIL))
                .setPhone(TestDataReader.getTestData(DATA_TEST_4_PHONE));
    }
}
