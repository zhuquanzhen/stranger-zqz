package com.stranger;

import com.stranger.dao.InumbersDao;
import com.stranger.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

//单元测试
@RunWith(SpringRunner.class)//表示在测试环境下跑,底层用的是junit
@SpringBootTest//表示启动整个spring的工程
public class GirlServiceTest {
    @Resource(name="girlinstance")
    private GirlService gs;
    //@Autowired
   // private InumbersDao numberdao;
    @Test
    public void  getAllTest(){

        //Assert断言类
        Assert.assertEquals(new Integer(8),new Integer(this.gs.getAllGirl().size()));
    }
    /*@Test
    public  void  testNumbet(){

    }*/
}
