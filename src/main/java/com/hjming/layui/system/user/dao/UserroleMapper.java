package com.hjming.layui.system.user.dao;

import com.hjming.layui.system.user.domain.Userrole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserroleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    Userrole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userrole record);

    int updateByPrimaryKey(Userrole record);
}