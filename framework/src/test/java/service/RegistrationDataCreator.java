package service;

import model.RegistrationData;
public class RegistrationDataCreator {
    private static String TESTDATA_REGISTRATION_DATA_EMAIL = "testdata.registrationData.email";

    public static RegistrationData withEmailOnlyFromProperty() {
        return new RegistrationData(TestDataReader.getTestData(TESTDATA_REGISTRATION_DATA_EMAIL));
    }
}
