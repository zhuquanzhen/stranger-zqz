package com.stranger.dao;

import com.stranger.base.BaseDao;
import com.stranger.domain.Numbers;
import org.apache.ibatis.annotations.Param;
public interface InumbersDao extends BaseDao<Numbers> {
        Numbers getBya(@Param("a") int a);
}
