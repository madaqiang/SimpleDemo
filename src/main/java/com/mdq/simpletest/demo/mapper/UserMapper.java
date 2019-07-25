package com.mdq.simpletest.demo.mapper;

import com.mdq.simpletest.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id = #{id}")
    User selectUser(int id);

    @Select("Select * from user")
    List<User> selectAll();

    List<User> selectByName(String name);

    @Insert({"insert into user(name,age) values(#{name},#{age})"})
    public int insertUser(User user);
        
}