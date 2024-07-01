package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CPF_CNPJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CPF_CNPJ, String> {

    private CPF_CNPJ constraintAnnotation;
    private final Util util = new Util();
    private final Validators validators = new Validators();

    @Override
    public void initialize(CPF_CNPJ constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    public boolean isValid(String value, boolean caseSentive) {
        value = util.sanitizationStringAlphaNumeric(value, !caseSentive);
        if (value.length() == 14) {
            if (!util.verifyStringUpperCase(value)) return false;
            return validators.validCnpj(value);
        }

        value = util.sanitizationStringNumeric(value);
        if (value.length() == 11) {
            return validators.validCpf(value);
        }

        return false;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        return isValid(value, constraintAnnotation.caseSensitive());
    }
}
