# CPF and CNPJ Validation Annotations for Java

Este projeto oferece anotações de validação para CPF e CNPJ seguindo o padrão JSR 380 do Java, permitindo inclusive a validação do novo CNPJ alfanumérico.

This project provides validation annotations for CPF and CNPJ following the Java JSR 380 standard, including support for the new alphanumeric CNPJ format.

---

## Usage / Uso

### 1. Maven Dependency / Dependência Maven

```xml

```

2. Adding Annotations / Adicionando Anotações  
CPF Validation / Validação de CPF
```java
import com.example.validation.CPF;

public class User {
    @CPF
    private String cpf;
    
    // getters and setters
}
```
CNPJ Validation / Validação de CNPJ
```java
import com.example.validation.CNPJ;

public class Company {
    @CNPJ
    private String cnpj;
    
    // getters and setters
}
```
CPF or CNPJ Validation / Validação de CPF ou CNPJ
```java
import com.example.validation.CPF_CNPJ;

public class Client {
    @CPF_CNPJ
    private String document;
    
    // getters and setters
}
```

3. Using in Validation / Utilizando na Validação
```java
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidatorExample {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        // Create objects to validate
        User user = new User();
        user.setCpf("123.456.789-09"); // Insert your CPF for testing
        
        Company company = new Company();
        company.setCnpj("12.345.678/0001-01"); // Insert your CNPJ for testing

        Client clientCO = new Client();
        clientCO.setDocument("12.345.678/0001-01"); // Isert your CNPJ for testing

        Client clientP = new Client();
        clientP.setDocument("123.456.789-09"); // Insert your CPF for testing
        
        // Validate objects
        Set<ConstraintViolation<User>> userViolations = validator.validate(user);
        Set<ConstraintViolation<Company>> companyViolations = validator.validate(company);
        Set<ConstraintViolation<Client>> clientCOViolations = validator.validate(clientCO);
        Set<ConstraintViolation<Client>> clientPViolations = validator.validate(clientP);
        
        // Handle violations as needed
        if (!userViolations.isEmpty()) {
            userViolations.forEach(violation -> System.out.println(violation.getMessage()));
        }
        
        if (!companyViolations.isEmpty()) {
            companyViolations.forEach(violation -> System.out.println(violation.getMessage()));
        }

        if (!clientCOViolations.isEmpty()) {
            clientCOViolations.forEach(violation -> System.out.println(violation.getMessage()));
        }

        if (!clientPViolations.isEmpty()) {
            clientPViolations.forEach(violation -> System.out.println(violation.getMessage()));
        }
    }
}
```

4. Running Tests / Executando Testes  
Para verificar se as anotações estão funcionando corretamente, execute os testes unitários fornecidos no projeto.  
To verify if the annotations are working correctly, run the provided unit tests in the project.

License / Licença   
This project is licensed under the MIT License. See the [LICENSE](https://www.mit.edu/~amini/LICENSE.md) for details.   
Este projeto está licenciado sob a Licença MIT. Consulte a [LICENSE](https://www.mit.edu/~amini/LICENSE.md) para mais detalhes.
