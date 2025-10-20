package com.yzzz.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzzz.common.utils.PageUtils;
import com.yzzz.common.utils.Query;
import com.yzzz.gulimall.product.dao.CategoryDao;
import com.yzzz.gulimall.product.entity.CategoryEntity;
import com.yzzz.gulimall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1. 先拿到所有的目录实体
        List<CategoryEntity> entities = baseMapper.selectList(null);

        List<CategoryEntity> categoryEntities = entities.stream().filter((entity) -> {
            if (entity.getParentCid() == 0)
                return true;
            return false;
        }).map(entity -> {
            entity.setChildren(childrenList(entity, entities));
            return entity;
        }).sorted((ent1, ent2) ->
                (ent1.getSort() == null?0:ent1.getSort()) - (ent2.getSort()==null?0:ent2.getSort())
        ).toList();
        return categoryEntities;
    }

    private List<CategoryEntity> childrenList(CategoryEntity categoryEntity, List<CategoryEntity> entities){
        List<CategoryEntity> categoryEntities = entities.stream().filter(entity ->
                Objects.equals(entity.getParentCid(), categoryEntity.getCatId())
        ).peek(entity ->
                entity.setChildren(childrenList(entity, entities))
        ).sorted((ent1, ent2) ->
                (ent1.getSort() == null?0:ent1.getSort()) - (ent2.getSort()==null?0:ent2.getSort())
        ).toList();
        return categoryEntities;
    }


}