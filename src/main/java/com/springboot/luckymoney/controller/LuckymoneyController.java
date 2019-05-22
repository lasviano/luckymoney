package com.springboot.luckymoney.controller;

import com.springboot.luckymoney.domain.Luckymoney;
import com.springboot.luckymoney.domain.Result;
import com.springboot.luckymoney.repository.LuckymoneyRepository;
import com.springboot.luckymoney.service.LuckymoneyService;
import com.springboot.luckymoney.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    private final static Logger logger = LoggerFactory.getLogger(LuckymoneyController.class);

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    /**
     *获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> getlist(){
//        System.out.println("luckymoneyList");
        logger.info("luckymoneyList");
        return repository.findAll();
    }

    /**
     * 创建红包（发红包）
     */
//    @PostMapping("/luckymoneys")
////    public Luckymoney createLuckymoney(@RequestParam("producer") String producer,
////                                       @RequestParam("money") BigDecimal money){
////        Luckymoney luckymoney = new Luckymoney();
////        luckymoney.setProducer(producer);
////        luckymoney.setMoney(money);
////        return repository.save(luckymoney);
////    }

    @PostMapping("/luckymoneys")
    public Result createLuckymoney(@Valid Luckymoney luckymoney, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.fail(1,bindingResult.getFieldError().getDefaultMessage());
        }else {
            Luckymoney oneNewMoney = new Luckymoney();
            oneNewMoney.setProducer(luckymoney.getProducer());
            oneNewMoney.setMoney(luckymoney.getMoney());
            repository.save(luckymoney);
            return ResultUtil.success(luckymoney);
        }
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
//    @PutMapping("/luckymoneys/{id}")
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

    @PostMapping("/luckymoneys/two")
    public void create(){
        service.sendLuckymoney();
    }

}
