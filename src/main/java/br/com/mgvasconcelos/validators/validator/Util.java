package br.com.mgvasconcelos.validators.validator;

public class Util {

    protected String sanitizationStringAlphaNumeric(String value, boolean upperCase) {
        value = value.replaceAll("[^a-zA-Z0-9]", "");
        if (upperCase) {
            value = value.toUpperCase();
        }

        return value;
    }

    protected String sanitizationStringNumeric(String value) {
        return value.replaceAll("[^0-9]", "");
    }

    protected boolean verifyStringUpperCase(String value) {
        return value.chars().mapToObj(i -> (char) i).noneMatch(Character::isLowerCase);
    }

}
