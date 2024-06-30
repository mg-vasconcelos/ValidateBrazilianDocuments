package br.com.mgvasconcelos.validators.constraints;

import br.com.mgvasconcelos.validators.validator.CnpjValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = CnpjValidator.class)
public @interface CNPJ {
    String message() default "CNPJ Inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean caseInsensitive() default false;
}
