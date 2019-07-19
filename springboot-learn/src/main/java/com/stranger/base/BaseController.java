package com.stranger.base;

import com.github.pagehelper.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.google.common.collect.Maps;

public abstract class BaseController {
   protected Object success() {
        return Result.success();
    }

    protected Object success(Object data) {
       // Result result = Result.success();
        Map<String, Object> table = Maps.newHashMap();
        if (data != null) {
            if (data instanceof Page) {
                Page<?> page = (Page<?>) data;

                table.put("total", page.getTotal());
                table.put("rows", page.getResult());
                //result.setData(table);
            } else {
                //result.setData(data);
            }
        }
        return table;
    }
    /*
    protected Object failure(String message) {
        return Result.failure(message);
    }

    protected Integer getUserId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        SysUser user = (SysUser) request.getAttribute(Constant.SUP_SYS_USER);
        return user.getId();
    }*/
}
