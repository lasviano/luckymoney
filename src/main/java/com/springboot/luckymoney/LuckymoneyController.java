package com.springboot.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    /**
     *获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> getlist(){
        return repository.findAll();
    }

    /**
     * 创建红包（发红包）
     */
    @PostMapping("/luckymoneys")
    public Luckymoney createLuckymoney(@RequestParam("producer") String producer,
                                       @RequestParam("money") BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findMoneyByID(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 跟新红包（领红包）
     */
    @PostMapping("/luckymoneys/{id}")
    public Luckymoney updateMoney(@PathVariable("id") Integer id,
                                  @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()){
            Luckymoney luckymoney = optional.get();
//            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }
}
