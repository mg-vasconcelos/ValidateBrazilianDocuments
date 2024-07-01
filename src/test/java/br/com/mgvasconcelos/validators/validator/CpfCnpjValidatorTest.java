package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CPF_CNPJ;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CpfCnpjValidatorTest {

    @Test
    public void isValidReturnsTrueForValidCNPJ() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertTrue(validator.isValid("11.222.333/0001-81", context));
    }

    @Test
    public void isValidReturnsTrueForValidCNPJButWrongMask() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertTrue(validator.isValid("11-222-333-0001-81", context));
        assertTrue(validator.isValid("11.222.333.0001.81", context));
        assertTrue(validator.isValid("11$222%333#0001@81", context));
    }

    @Test
    public void isValidReturnsTrueForValidCNPJWithLetters() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertTrue(validator.isValid("AABBBCCCDDDD52", context));
    }

    @Test
    public void isValidReturnsTrueForValidCNPJWithLettersInsensitive() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(false);

        validator.initialize(cpf_cnpj);

        assertTrue(validator.isValid("AaBbbCccDddd52", context));
        assertTrue(validator.isValid("aabbbcccdddd52", context));
        assertTrue(validator.isValid("Aabbbcccdddd52", context));
        assertTrue(validator.isValid("aaBbbcccDddd52", context));
    }

    @Test
    public void isValidReturnsFalseForValidCNPJButSensitiveCase() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertFalse(validator.isValid("AaBbbCccDddd52", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCNPJWithLetters() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertFalse(validator.isValid("AABBBCCCDDDD53", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCNPJWithLettersAndLettersInDigit() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertFalse(validator.isValid("AA.BBB.CCC/DDDD-EE", context));
    }

    @Test
    public void isValidReturnsTrueForValidCPF() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertTrue(validator.isValid("123.456.789-09", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCNPJ() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertFalse(validator.isValid("11.222.333/0001-82", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCPF() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertFalse(validator.isValid("123.456.789-11", context));
    }

    @Test
    public void isValidReturnsTrueWhenValueIsNull() {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CPF_CNPJ cpf_cnpj = mock(CPF_CNPJ.class);
        when(cpf_cnpj.caseSensitive()).thenReturn(true);

        validator.initialize(cpf_cnpj);

        assertTrue(validator.isValid(null, context));
        assertTrue(validator.isValid("", context));
    }
}