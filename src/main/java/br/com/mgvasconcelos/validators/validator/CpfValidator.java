package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CPF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator  implements ConstraintValidator<CPF, String> {
    private final int[] MULTIPLY_MATRIX = {2,3,4,5,6,7,8,9,10,11};

    @Override
    public void initialize(CPF constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        value = sanitizationString(value);
        if (value.length() != 11) return false;

        return validCpf(value);
    }

    private boolean validCpf(String value) {
        String document = value.substring(0, 9);

        for(int i = 0; i < 2; i++) {
            int sum = sumAllValuesForValidRules(document);
            int oneDigit = generateDigit(sum);

            document = document.concat(String.valueOf(oneDigit));
        }

        return value.equals(document);

    }

    private int sumAllValuesForValidRules(String document) {
        document = new StringBuilder(document).reverse().toString();

        int sum = 0;
        for (int i = 0; i < document.length(); i++) {
            sum += Character.getNumericValue(document.charAt(i)) * MULTIPLY_MATRIX[i];
        }
        return sum;
    }

    private String sanitizationString(String value) {
        return value.replaceAll("[^0-9]", "");
    }

    private int generateDigit(int sum) {
        int rest = (sum * 10) % 11;
        return rest > 9 ? 0 : rest;
    }
}
