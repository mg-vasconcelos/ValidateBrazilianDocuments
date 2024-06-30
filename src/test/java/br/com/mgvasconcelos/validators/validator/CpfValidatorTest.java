package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CPF;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CpfValidatorTest {
    @Test
    public void isValidReturnsTrueForValidCPF() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertTrue(validator.isValid("12345678909", context));
    }

    @Test
    public void isValidReturnsTrueForValidCPFFormated() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertTrue(validator.isValid("123.456.789-09", context));
    }

    @Test
    public void isValidReturnsTrueForValidCPFWrongMask() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertTrue(validator.isValid("123$456$789/09", context));
    }

    @Test
    public void isValidReturnsTrueForValidCPFWithLetters() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertTrue(validator.isValid("123C456B789A09", context));
        assertTrue(validator.isValid("123C456B789DV09", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCPF() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertFalse(validator.isValid("12345678900", context));
    }

    @Test
    public void isValidReturnsTrueWhenValueIsNull() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertTrue(validator.isValid(null, context));
    }

    @Test
    public void isValidReturnsFalseWhenValueLengthIsNotEqualToMaxLength() {
        CpfValidator validator = new CpfValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF cpf = mock(CPF.class);

        validator.initialize(cpf);

        assertFalse(validator.isValid("1234567890", context));
    }

}
