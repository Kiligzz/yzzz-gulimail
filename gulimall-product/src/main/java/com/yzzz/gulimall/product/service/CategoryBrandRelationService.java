package com.yzzz.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzzz.common.utils.PageUtils;
import com.yzzz.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author yzzz
 * @email 453040138@qq.com
 * @date 2025-10-13 19:19:56
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

