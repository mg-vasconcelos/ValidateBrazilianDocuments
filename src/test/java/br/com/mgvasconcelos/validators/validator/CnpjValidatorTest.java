package br.com.mgvasconcelos.validators.validator;

import br.com.mgvasconcelos.validators.constraints.CNPJ;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CnpjValidatorTest {

    @Test
    public void isValidReturnsTrueForValidCNPJ() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertTrue(validator.isValid("11.222.333/0001-81", context));
    }

    @Test
    public void isValidReturnsTrueForValidCNPJButWrongMask() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertTrue(validator.isValid("11-222-333-0001-81", context));
        assertTrue(validator.isValid("11.222.333.0001.81", context));
        assertTrue(validator.isValid("11$222%333#0001@81", context));
    }

    @Test
    public void isValidReturnsTrueForValidCNPJWithLetters() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertTrue(validator.isValid("AABBBCCCDDDD52", context));
    }

    @Test
    public void isValidReturnsTrueForValidCNPJWithLettersInsensitive() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertTrue(validator.isValid("AaBbbCccDddd52", context));
        assertTrue(validator.isValid("aabbbcccdddd52", context));
        assertTrue(validator.isValid("Aabbbcccdddd52", context));
        assertTrue(validator.isValid("aaBbbcccDddd52", context));
    }

    @Test
    public void isValidReturnsFalseForValidCNPJButSensitiveCase() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(false);

        validator.initialize(cnpj);

        assertFalse(validator.isValid("AaBbbCccDddd52", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCNPJ() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertFalse(validator.isValid("11.222.333/0001-82", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCNPJWithLetters() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertFalse(validator.isValid("AABBBCCCDDDD53", context));
    }

    @Test
    public void isValidReturnsFalseForInvalidCNPJWithLettersAndLettersInDigit() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertFalse(validator.isValid("AA.BBB.CCC/DDDD-EE", context));
    }

    @Test
    public void isValidReturnsTrueWhenValueIsNull() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertTrue(validator.isValid(null, context));
    }

    @Test
    public void isValidReturnsFalseWhenValueLengthIsNotEqualToMaxLength() {
        CnpjValidator validator = new CnpjValidator();
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);

        CNPJ cnpj = mock(CNPJ.class);
        when(cnpj.caseInsensitive()).thenReturn(true);

        validator.initialize(cnpj);

        assertFalse(validator.isValid("11.222.333/0001-811", context));
    }
}
