package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CNPJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CnpjValidator implements ConstraintValidator<CNPJ, String> {

    private final Validators validators = new Validators();
    private final Util util = new Util();
    private CNPJ constraintAnnotation;

    public boolean isValid(String value, boolean caseSentive) {
        value = util.sanitizationStringAlphaNumeric(value, !caseSentive);
        if (!util.verifyStringUpperCase(value)) return false;

        if (value.length() != 14) {
            return false;
        }

        return validators.validCnpj(value);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return true;
        return isValid(value, constraintAnnotation.caseSensitive());
    }

    @Override
    public void initialize(CNPJ constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

}
