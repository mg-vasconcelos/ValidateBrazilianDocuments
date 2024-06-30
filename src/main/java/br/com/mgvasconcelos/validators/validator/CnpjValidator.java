package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CNPJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CnpjValidator implements ConstraintValidator<CNPJ, String> {

    private CNPJ constraintAnnotation;
    private final int[] MULTIPLY_MATRIX = {2,3,4,5,6,7,8,9,2,3,4,5,6};

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        value = sanitizationString(value);
        if (!verifyStringUpperCase(value)) {
            return false;
        }

        if (value.length() != 14) {
            return false;
        }

        return validCnpj(value);
    }

    @Override
    public void initialize(CNPJ constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    private String sanitizationString(String value) {
        value = value.replaceAll("[^a-zA-Z0-9]", "");
        if (constraintAnnotation.caseInsensitive()) {
            value = value.toUpperCase();
        }

        return value;
    }

    private boolean verifyStringUpperCase(String value) {
        return value.chars().mapToObj(i -> (char) i).noneMatch(Character::isLowerCase);
    }

    private boolean validCnpj(String value) {

        String document = value.substring(0, 12);

        for (int i = 0; i < 2; i++) {
            int sum = sumAllAcciiValuesForValidRules(document);
            int oneDigit = generateDigit(sum);

            document = document.concat(String.valueOf(oneDigit));

        }

        return value.equals(document);

    }

    private int sumAllAcciiValuesForValidRules(String value) {
        int result = 0;

        String revert = new StringBuilder(value).reverse().toString();

        for (int i = 0; i < revert.length(); i++) {
            result += ((int) revert.charAt(i) - 48) * MULTIPLY_MATRIX[i];
        }

        return result;

    }

    private int generateDigit(int value) {
        int result = value % 11;
        if (result < 2) {
            result = 0;
        }

        return 11 - result;
    }
}
