package com.terran4j.springboot.web.tem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TempController {

    @ResponseBody
    @GetMapping("api/get")
    public ServiceResponse get() {
        ServiceResponse response = new ServiceResponse();
        response.setTotal(10);
        response.setTo(1);
        response.setCurrentPage(1);
        response.setFrom(1);
        response.setLastPage(1);
        response.setNextPageUrl("aa");
        response.setPrevPageUrl(null);
        response.setPerPage(1);

        List<Data> list = new ArrayList<>();
        Data d = new Data();
        d.setAge(18);
        d.setBirthdate("safds");
        d.setEmail("932852117@qq.com");
        d.setGender("fff");
        d.setCreatedAt("2022-10-26 18:06:10");
        d.setName("sdggg");
        d.setId(1);
        d.setNickname("kkkkk");
        d.setSalary("66666");
        d.setUpdatedAt("2022-10-26 18:06:20");
        d.setGroupId(1);

        Group group = new Group();
        group.setId(1);
        group.setDescription("你妹的");
        group.setName("牛牛");
        d.setGroup(group);

        Address address = new Address();
        address.setFax("aaa");
        address.setId(1);
        address.setLine1("111");
        address.setMobile("13546895689");
        address.setZipcode("zzz");
        address.setLine2("222");
        address.setUserId(2244);
        address.setFax("sdfsdf");
        d.setAddress(address);

        list.add(d);

        response.setData(list);


        return response;
    }
}
