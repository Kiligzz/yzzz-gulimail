package com.yzzz.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzzz.common.utils.PageUtils;
import com.yzzz.gulimall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author yzzz
 * @email 453040138@qq.com
 * @date 2025-10-14 11:16:46
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

