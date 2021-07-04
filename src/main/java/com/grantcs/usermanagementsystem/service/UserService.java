package com.grantcs.usermanagementsystem.service;

import com.grantcs.usermanagementsystem.domain.MUser;

import java.util.List;

public interface UserService {
    /**
     * User signup
     */
    public void signup(final MUser user);

    /**
     * Get users
     */
    public List<MUser> getUsers(final MUser user);

    /**
     * Get user (1 record)
     */
    public MUser getUserOne(final String userId);

    /**
     * Update user
     */
    public void updateUserOne(final String userId,
                              final String password,
                              final String userName);

    /**
     * Delete user
     */
    public void deleteUserOne(final String userId);

    /**
     * Get login information
     */
    public MUser getLoginUser(final String userId);
}
