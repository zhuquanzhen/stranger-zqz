package com.stranger.base;

import cn.hutool.core.convert.Convert;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query extends LinkedHashMap<String,Object> {
    private int pageSize=5;
    private int pageNum=1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNUm(int pageNum) {
        this.pageNum = pageNum;
    }
    public Query(){super();}
    public Query(Map<String,Object> map){
        //合并两个map
        this.putAll(map);
        this.pageNum= Convert.toInt(map.get("page"),this.pageNum);
        this.pageSize=Convert.toInt(map.get("rows"),this.pageSize);
        this.put("pageNum",this.pageNum);
        this.put("pageSize",this.pageSize);
    }
}
