package com.stranger.service;

import com.stranger.Exception.GirlException;
import com.stranger.domain.Girl;
import com.stranger.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Exception;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("girlinstance")
public class GirlService {
    @Autowired
    private JdbcTemplate jt;
    public void  insertGirl(Girl girl)throws Exception{
        System.out.println(girl.toString());
        String sql ="insert into girl values(?,?,?)";
       // System.out.println("执行到这");
       int row= this.jt.update(sql,girl.getName(),girl.getCupSize(),girl.getAge());
       System.out.println(row);
    }
    public void  getAge(final String name) throws Exception{
        String sql="select t.age from girl t where t.name=?";
        Girl girl=new Girl();
        this.jt.query(sql,new Object[]{name},new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
               girl.setAge(rs.getByte("age"));
            }

        });
        int age=girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<20){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            throw new GirlException(ResultEnum.HIGHT_SCHOOL);
        }
    }

    /**
     * 查询表中全部数据
     * @return
     */
    public List<Map<String,Object>> getAllGirl(){
        String sql="select * from girl";
        List<Map<String,Object>> list=null;
        list=this.jt.queryForList(sql);
        return list;
    }
}
