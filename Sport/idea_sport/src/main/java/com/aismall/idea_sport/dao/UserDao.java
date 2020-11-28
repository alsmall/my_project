package com.aismall.idea_sport.dao;

import com.aismall.idea_sport.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
     public int getUserByMessage(@Param("username")String username, @Param("password")String password);
}
