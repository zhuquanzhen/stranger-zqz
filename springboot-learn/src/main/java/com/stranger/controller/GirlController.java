package com.stranger.controller;

import com.stranger.domain.Girl;
import com.stranger.domain.Result;
import com.stranger.enums.ResultEnum;
import com.stranger.service.GirlService;
import com.stranger.util.ResultUtil;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.xml.ws.RespectBinding;
import java.util.List;
import java.util.Map;

@RestController
public class GirlController {
    @Resource(name="girlinstance")
    private GirlService gs;
    @RequestMapping("/insertGirl")
    public Object insertGirl(@Valid Girl girl, BindingResult br)throws Exception{//@Vail启用验证，BindingResult验证结果
        Result<Girl> result=new Result<Girl>();
        if(br.hasErrors()){//如果有错打印
            //System.out.println(br.getFieldError().getDefaultMessage());
            return ResultUtil.error(ResultEnum.ERROR.getCode(),br.getFieldError().getDefaultMessage());
        }
        this.gs.insertGirl(girl);
        return ResultUtil.success(girl);
    }
    @GetMapping(value="/getAge/{name}")
    public void  getAge(@PathVariable("name") String name) throws Exception{

        this.gs.getAge(name);
    }
    @GetMapping(value="/getAllGirl")
    public List<Map<String,Object>> getAllGirl() throws Exception{
        return this.gs.getAllGirl();
    }
}
