package com.yzzz.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzzz.common.utils.PageUtils;
import com.yzzz.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author yzzz
 * @email 453040138@qq.com
 * @date 2025-10-14 11:21:00
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

