package com.grantcs.usermanagementsystem.service.impl;

import com.grantcs.usermanagementsystem.domain.MUser;
import com.grantcs.usermanagementsystem.repository.UserMapper;
import com.grantcs.usermanagementsystem.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(final UserMapper mapper,
                           final PasswordEncoder passwordEncoder) {

        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signup(final MUser user) {
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword));
        mapper.insertOne(user);
    }

    @Override
    public List<MUser> getUsers(final MUser user) {
        return mapper.findMany(user);
    }

    @Override
    public MUser getUserOne(final String userId) {
        return mapper.findOne(userId);
    }

    @Override
    public void updateUserOne(final String userId,
                              final String password,
                              final String userName) {

        String encryptPassword = passwordEncoder.encode(password);
        mapper.updateOne(userId, password, userName);
    }

    @Override
    public void deleteUserOne(final String userId) {
        int count = mapper.deleteOne(userId);
    }

    @Override
    public MUser getLoginUser(String userId) {
        return mapper.findLoginUser(userId);
    }
}
