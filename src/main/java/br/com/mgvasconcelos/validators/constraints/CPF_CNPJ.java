package br.com.mgvasconcelos.validators.constraints;

import br.com.mgvasconcelos.validators.validator.CpfCnpjValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = CpfCnpjValidator.class)
public @interface CPF_CNPJ {
    String message() default "Documento Inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean caseSensitive() default true;

}
