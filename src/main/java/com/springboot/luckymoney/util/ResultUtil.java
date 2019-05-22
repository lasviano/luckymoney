package com.springboot.luckymoney.util;

import com.springboot.luckymoney.domain.Luckymoney;
import com.springboot.luckymoney.domain.Result;

public class ResultUtil {
    public static Result success(Luckymoney luckymoney){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(luckymoney);
        return result;
    }

    public static Result fail(Integer code,String failMsg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(failMsg);
        return result;
    }
}
