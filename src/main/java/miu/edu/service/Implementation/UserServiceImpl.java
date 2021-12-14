package miu.edu.service.Implementation;

import miu.edu.model.User;
import miu.edu.repository.UserRepository;
import miu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUserAccount(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword())); // encrypt
        return repository.save(newUser);
    }

}
