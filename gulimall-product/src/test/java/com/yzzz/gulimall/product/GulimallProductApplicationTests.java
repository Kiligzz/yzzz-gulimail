package com.yzzz.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzzz.gulimall.product.entity.BrandEntity;
import com.yzzz.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;



    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();

//        brandEntity.setName("huawei");
//        brandService.save(brandEntity);
//        brandEntity.setDescript("huawei");
//        brandEntity.setBrandId(1L);
//        brandService.updateById(brandEntity);
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("descript", "huawei"));
        list.forEach(System.out::println);
        System.out.println("整合完毕");
    }

}
