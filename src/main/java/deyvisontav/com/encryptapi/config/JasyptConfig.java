package deyvisontav.com.encryptapi.config;

import org.jasypt.util.binary.AES256BinaryEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Value( "${encrypt.key}" )
    private String secretKey;
    @Bean
    public AES256BinaryEncryptor createEncryptor() {
        AES256BinaryEncryptor textEncryptor = new AES256BinaryEncryptor();
        textEncryptor.setPassword(secretKey);
        return textEncryptor;
    }
}
