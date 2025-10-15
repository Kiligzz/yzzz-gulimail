package com.yzzz.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzzz.common.utils.PageUtils;
import com.yzzz.gulimall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author yzzz
 * @email 453040138@qq.com
 * @date 2025-10-14 11:16:46
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

