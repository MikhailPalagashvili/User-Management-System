package com.grantcs.usermanagementsystem.repository;

import com.grantcs.usermanagementsystem.domain.MUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * User signup
     */
    public int insertOne(final MUser user);

    /**
     * Get user
     */
    public List<MUser> findMany(MUser user);

    /**
     * Get user(1 record)
     */
    public MUser findOne(final String userId);

    /**
     * Update user
     */
    public void updateOne(@Param("userId") final String userId,
                          @Param("password") final String password,
                          @Param("userName") final String userName);

    /**
     * Delete user
     */
    public int deleteOne(@Param("userId") final String userId);

    /**
     * Get login user
     */
    public MUser findLoginUser(final String userId);
}
