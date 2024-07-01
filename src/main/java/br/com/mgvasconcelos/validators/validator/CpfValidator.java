package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CPF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator  implements ConstraintValidator<CPF, String> {
    private final Util util = new Util();
    private final Validators validators = new Validators();

    @Override
    public void initialize(CPF constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    public boolean isValid(String value) {
        value = util.sanitizationStringNumeric(value);
        if (value.length() != 11) return false;

        return validators.validCpf(value);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return true;
        return isValid(value);
    }

}
