package com.yzzz.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzzz.common.utils.PageUtils;
import com.yzzz.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author yzzz
 * @email 453040138@qq.com
 * @date 2025-10-13 19:19:56
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

