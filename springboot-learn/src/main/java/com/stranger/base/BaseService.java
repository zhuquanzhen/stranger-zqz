package com.stranger.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Transactional(readOnly=true)
public abstract class BaseService<D extends BaseDao<T>,T> {
    @Resource
    protected D dao;
    public List<T> selectList(Map<String,Object> map){
        return this.dao.selectList(map);
    }
    public Page<T> selectPage(Map<String,Object> map){
        Query query=new Query(map);
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        return (Page<T>)this.dao.selectList(query);
    }
}
