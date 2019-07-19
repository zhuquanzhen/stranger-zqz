package com.stranger.controller;

import com.stranger.domain.GirlProperies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
   /* @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${conten}")
    private String conten;*/
   @Autowired
    private GirlProperies gir;
    @RequestMapping(value={"/hello","/ha"},method= RequestMethod.GET)//url可以写成集合
    public String  test(){
        return "哈哈";
    }
    @RequestMapping("/cup")
    public String getCup(){
       // return this.cupSize+"年龄="+this.age+'\n'+this.conten;
        return this.gir.getCupSize()+this.gir.getAge()+"1234";
    }
    @RequestMapping(value="/param/{id}")//表示id是一个参数在url的相同位置,http://localhost:8082/girl/param/1214
    public Integer  testParam(@PathVariable("id") Integer id){
        return  id;
    }
    @RequestMapping(value="{name}/param1")
    public String getName(@PathVariable("name") String name){//http://localhost:8082/girl/zhuquanzhen/param1/
        return name;
    }
    @RequestMapping(value="/getAge")
    public String  getAge(@RequestParam("age") String age){//http://localhost:8082/girl/getAge?age=13
        return age;

    }
}
