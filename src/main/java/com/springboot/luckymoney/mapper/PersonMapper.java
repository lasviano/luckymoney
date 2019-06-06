package com.springboot.luckymoney.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.luckymoney.domain.Person;
import org.springframework.stereotype.Component;

@Component
public interface PersonMapper extends BaseMapper<Person> {
}
