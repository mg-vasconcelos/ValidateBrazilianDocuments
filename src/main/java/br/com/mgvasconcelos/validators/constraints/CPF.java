package br.com.mgvasconcelos.validators.constraints;

import br.com.mgvasconcelos.validators.validator.CpfValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = CpfValidator.class)
public @interface CPF {

    String message() default "CPF Inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
