package com.yzzz.gulimall.order.dao;

import com.yzzz.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yzzz
 * @email 453040138@qq.com
 * @date 2025-10-14 11:21:00
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
