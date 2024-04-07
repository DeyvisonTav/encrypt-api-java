package deyvisontav.com.encryptapi.config;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Value("${encryptor.password}")
    private String encryptionPassword;
    @Bean
    public AES256TextEncryptor textEncryptor() {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword(encryptionPassword);
        return encryptor;
    }
}

