package com.nrvcer.springcloud.myhandler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nrvcer.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息1......CustomerBlockHandler");
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息2......CustomerBlockHandler");
    }
}
