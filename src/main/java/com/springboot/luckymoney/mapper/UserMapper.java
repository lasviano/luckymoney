package com.springboot.luckymoney.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.luckymoney.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
}
