package com.mingyueTech.dao;

import com.mingyueTech.entity.PostDetail;

public interface PostDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostDetail record);

    int insertSelective(PostDetail record);

    PostDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostDetail record);

    int updateByPrimaryKey(PostDetail record);
}