package com.wzz.mybatisplusstudy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzz.mybatisplusstudy.entity.User;
import com.wzz.mybatisplusstudy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MybatisplusStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper mapper;

    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User user = new User();
        user.setName("xhm");
        user.setAge(23);
        mapper.insert(user);
        System.out.println(user);
    }

    @Test
    void update(){
        User user = mapper.selectById(13);
        user.setName("1");
        User user2 = mapper.selectById(13);
        user2.setName("2");
        mapper.updateById(user);
        mapper.updateById(user2);
    }

    @Test
    void remove(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",10);
        mapper.deleteByMap(map);
    }

    //全部查询
    @Test
    void select01(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",20);
        mapper.selectList(wrapper).forEach(System.out::println);
        mapper.selectMaps(wrapper).forEach(System.out::println);

    }
    //分页查询
    @Test
    void select02(){
//        Page<User> page = new Page<>(2,2);
//        Page<User> result = mapper.selectPage(page,null);
//        System.out.println(result.getSize());
//        System.out.println(result.getTotal());
//        result.getRecords().forEach(System.out::println);

        Page<Map<String,Object>> page = new Page<>(2,2);
        mapper.selectMapsPage(page,null).getRecords().forEach(System.out::println);

//        mapper.selectObjs(null).forEach(System.out::println);
    }

}
