package com.stranger;

import com.stranger.dao.InumbersDao;
import com.stranger.service.NumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)//表示在测试环境下跑,底层用的是junit
@SpringBootTest
public class NumbetTest {
    @Autowired(required = false)
    private InumbersDao nd;
    @Resource
    private NumberService ns;
    @Test
    public void testNumber(){
        Map<String,Object> param=new HashMap<String,Object>();
       System.out.println(this.nd.selectList(param).size());
    }
    @Test
    public void testNumberService(){
        Map<String,Object> param=new HashMap<String,Object>();
        System.out.println(this.ns.selectList(param).size());
    }
}
