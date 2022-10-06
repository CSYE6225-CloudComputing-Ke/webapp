package io.ke.web.dependencies;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import io.ke.web.validators.UserValidator;





@Configuration
public class BeanFactory {
    @Bean
    public BCryptPasswordEncoder pwdEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserValidator userValidator(){
        return new UserValidator();
    }

 

    @Bean
    public BasicAuthenticationEntryPoint authenticationEntryPoint() {
        return new BasicAuthenticationEntryPoint() {
            @Override
            public void afterPropertiesSet() throws RuntimeException {
                setRealmName("webapp");
                super.afterPropertiesSet();
            }

        };
    }
}
