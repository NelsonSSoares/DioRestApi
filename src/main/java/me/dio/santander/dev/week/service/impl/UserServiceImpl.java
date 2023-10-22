package me.dio.santander.dev.week.service.impl;

import me.dio.santander.dev.week.domain.model.User;
import me.dio.santander.dev.week.domain.repository.UserRepository;
import me.dio.santander.dev.week.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {

        if(user.getId() != null && userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("This user id already exists.");
        }else if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("this account number already exists.");
        }

        return userRepository.save(user);
    }
}
