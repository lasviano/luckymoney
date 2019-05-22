package com.springboot.luckymoney.service;

import com.springboot.luckymoney.domain.Luckymoney;
import com.springboot.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    @Transactional
    public void sendLuckymoney(){
        Luckymoney firstLuckymoney = new Luckymoney();
        firstLuckymoney.setProducer("xu");
        firstLuckymoney.setMoney(new BigDecimal("520"));
        repository.save(firstLuckymoney);

        Luckymoney secondLuckymoney = new Luckymoney();
        secondLuckymoney.setProducer("xu");
        secondLuckymoney.setMoney(new BigDecimal("1314"));
        repository.save(secondLuckymoney);
    }
}
