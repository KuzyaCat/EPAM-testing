package service;

import model.User;

public class UserCreator {
    private static String TESTDATA_USER_EMAIL = "testdata.user.email";
    private static String TESTDATA_USER_PASSWORD = "testdata.user.password";
    private static String TESTDATA_USER_WRONG_EMAIL = "testdata.user.wrongEmail";
    private static String TESTDATA_USER_WRONG_FORMAT_EMAIL = "testdata.user.wrongFormatEmail";
    private static String TESTDATA_USER_WRONG_PASSWORD = "testdata.user.wrongPassword";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL), TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withWrongEmail() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_WRONG_EMAIL), TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withWrongFormatEmail() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_WRONG_FORMAT_EMAIL), TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withWrongPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_WRONG_FORMAT_EMAIL), TestDataReader.getTestData(TESTDATA_USER_WRONG_PASSWORD));
    }
}
