package com.springboot.luckymoney.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LuckymoneyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wc;

    @Before
    public void beforeSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }

    @Test
    public void testSelectMoney(){

//        MvcResult result = this.mockMvc.perform(get("/mock").param("msg", msg)).andDo(print()).andExpect(status().isOk());
//        Assert.assertEquals();
    }

}