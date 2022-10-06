package io.ke.web.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import io.ke.web.errors.RegistrationStatus;
import io.ke.web.models.CustomUserDetails;
import io.ke.web.models.User;
import io.ke.web.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;

    public void register(User user) {
        user.setPassword(pwdEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Boolean isEmailPresent(String emailId) {
        return userRepository.isEmailPresent(emailId) > 0 ? true : false;
    }

    public RegistrationStatus getRegistrationStatus(BindingResult errors) {
        FieldError emailIdError = errors.getFieldError("emailId");
        FieldError passwordError = errors.getFieldError("password");
        String emailIdErrorMessage = emailIdError == null ? "-" : emailIdError.getCode();
        String passwordErrorMessage = passwordError == null ? "-" : passwordError.getCode();
        return new RegistrationStatus(emailIdErrorMessage, passwordErrorMessage);
    }

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(emailId);
        if(user==null) throw new UsernameNotFoundException("User with given emailId does not exist");
        else return new CustomUserDetails(user);
    }

}

