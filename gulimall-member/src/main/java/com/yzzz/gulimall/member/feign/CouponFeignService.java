package com.yzzz.gulimall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient
public class CouponFeignService {
    @RequestMapping()
}
