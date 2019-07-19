package com.stranger.controller;

import com.stranger.base.BaseController;
import com.stranger.base.Result;
import com.stranger.domain.Numbers;
import com.stranger.service.NumberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NumberController extends BaseController {
    @Resource
    NumberService na;
    @PostMapping ("/getAll")
    public Object queryAll(@RequestBody Map<String,Object> map){
        System.out.println(map.toString());
        Map<String,Object> re=new HashMap<String,Object>();
        re.put("rows",this.na.selectList(map));
       return re;
       // return this.na.selectList(map);
    }
    @PostMapping("/getPage")
    public Object queryByPage(@RequestParam Map<String,Object> map){
        //System.out.println(this.na.selectPage(map));
        return this.success(this.na.selectPage(map));
    }
}
