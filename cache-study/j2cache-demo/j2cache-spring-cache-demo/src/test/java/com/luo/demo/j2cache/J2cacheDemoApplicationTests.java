package com.luo.demo.j2cache;

import com.luo.demo.j2cache.bean.MyObj;
import com.luo.demo.j2cache.service.MyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class J2cacheDemoApplicationTests {

    @Resource
    private MyService myService;

    @Test
    void testSpringCache() {
        Long id1 = 1L, id2 = 2L;

        //第1次查询myObj1缓存为空，则执行对应方法逻辑加载，num=1
        MyObj myObj1 = this.myService.getMyObj(id1);
        Assertions.assertEquals(1, myObj1.getNum(), "第1次查询myObj1（为空需设置缓存）");

        //第2次查询myObj1缓存非空，则直接从缓存获取, num=1
        myObj1 = this.myService.getMyObj(id1);
        Assertions.assertEquals(1, myObj1.getNum(), "第2次查询myObj1（缓存非空）");

        //第1次修改myObj1，则执行对应更新逻辑num+=1，并重置缓存
        myObj1.setName(myObj1.getName() + "_update");
        myObj1 = this.myService.updateMyObjWithReturn(myObj1);
        Assertions.assertEquals(2, myObj1.getNum(), "第1次更新myObj1");

        //第3次查询myObj1缓存非空，则直接从缓存获取, num=2
        myObj1 = this.myService.getMyObj(id1);
        Assertions.assertEquals(2, myObj1.getNum(), "第3次查询myObj1（缓存非空）");

        //第2次修改myObj1，缓存为空，则执行对应方法逻辑加载，num=3
        Integer retCount = this.myService.updateMyObj(myObj1);
        Assertions.assertEquals(1, retCount, "更新myObj1 - 返回结果");
        Assertions.assertEquals(3, myObj1.getNum(), "更新myObj1");

        //第4次查询myObj1缓存非空，则直接从缓存获取, num=4
        myObj1 = this.myService.getMyObj(id1);
        Assertions.assertEquals(4, myObj1.getNum(), "第3次查询myObj1（缓存非空）");



        //第1次查询myObj2缓存为空，则执行对应方法逻辑加载，num=5
        MyObj myObj2 = this.myService.getMyObj(id2);
        Assertions.assertEquals(5, myObj2.getNum(), "第1次查询myObj2");

        //删除myObj1（同时删除缓存中myObj1）
        retCount = this.myService.deleteMyObj(id1);
        Assertions.assertEquals(1, retCount, "删除myObj1");

        //删除所有myObj（同时删除缓存中所有myObj）
        retCount = this.myService.deleteAllMyObj();
        Assertions.assertEquals(1, retCount, "删除所有myObj");
    }




}
