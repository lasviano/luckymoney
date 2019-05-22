package com.springboot.luckymoney.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
public class Luckymoney {

    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 50,message = "红包太小")
    private BigDecimal money;

    private String consumer;

    private String producer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Luckymoney{" +
                "id=" + id +
                ", money=" + money +
                ", consumer='" + consumer + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
