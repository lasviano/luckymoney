package com.springboot.luckymoney;

import com.springboot.luckymoney.domain.Person;
import com.springboot.luckymoney.entity.FileEntity;
import com.springboot.luckymoney.entity.User;
import com.springboot.luckymoney.mapper.FileEntityMapper;
import com.springboot.luckymoney.mapper.PersonMapper;
import com.springboot.luckymoney.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private PersonMapper personMapper;
//    private UserMapper userMapper;
    @Autowired
    private FileEntityMapper fileEntityMapper;

    @Test
    public void testSelect(){
        System.out.println("----- selectAll method test ------");
        List<FileEntity> userList = fileEntityMapper.selectList(null);
//        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(3, userList.size());
        userList.forEach(System.out::println);
    }
}
