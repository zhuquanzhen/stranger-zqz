package com.stranger.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    Integer insert(T entity);
    List<T> selectList(Map<String,Object> param);
}
