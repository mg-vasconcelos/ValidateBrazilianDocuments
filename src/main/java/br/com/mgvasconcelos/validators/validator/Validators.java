package br.com.mgvasconcelos.validators.validator;

public class Validators {

    private final int[] MULTIPLY_MATRIX_CNPJ = {2,3,4,5,6,7,8,9,2,3,4,5,6};
    private final int[] MULTIPLY_MATRIX_CPF = {2,3,4,5,6,7,8,9,10,11};

    protected boolean validCpf(String value) {
        String document = value.substring(0, 9);

        for(int i = 0; i < 2; i++) {
            int sum = sumAllValuesForValidRules(document, MULTIPLY_MATRIX_CPF);
            int oneDigit = generateDigitCpf(sum);

            document = document.concat(String.valueOf(oneDigit));
        }

        return value.equals(document);
    }

    protected boolean validCnpj(String value) {
        String document = value.substring(0, 12);

        for (int i = 0; i < 2; i++) {
            int sum = sumAllAcciiValuesForValidRules(document, MULTIPLY_MATRIX_CNPJ);
            int oneDigit = generateDigitCnpj(sum);

            document = document.concat(String.valueOf(oneDigit));

        }

        return value.equals(document);
    }

    private int sumAllValuesForValidRules(String document, int[] MultiplyMatrix) {
        document = new StringBuilder(document).reverse().toString();

        int sum = 0;
        for (int i = 0; i < document.length(); i++) {
            sum += Character.getNumericValue(document.charAt(i)) * MultiplyMatrix[i];
        }
        return sum;
    }

    private int sumAllAcciiValuesForValidRules(String document, int[] MultiplyMatrix) {
        document = new StringBuilder(document).reverse().toString();

        int sum = 0;
        for (int i = 0; i < document.length(); i++) {
            sum += ((int) document.charAt(i) -48) * MultiplyMatrix[i];
        }
        return sum;
    }

    private int generateDigitCpf(int sum) {
        int rest = (sum * 10) % 11;
        return rest > 9 ? 0 : rest;
    }

    private int generateDigitCnpj(int value) {
        int result = value % 11;
        if (result < 2) {
            result = 0;
        }

        return 11 - result;
    }
}
