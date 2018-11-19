package com.mdq.simpletest.demo.mapper;

import com.mdq.simpletest.demo.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id = #{id}")
    User selectUser(int id);

    @Select("Select * from User")
    List<User> selectAll();

    List<User> selectByName(String name);
}