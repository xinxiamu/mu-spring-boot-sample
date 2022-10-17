package com.example.demo.test1;

import com.example.demo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/interlib")
public class InterlibController {

    @Autowired
    private InterlibService interlibService;

    /**
     * 获取interlib的SessionId信息
     * @return
     */
    @GetMapping("/getSession")
    public Result<String> getSessionId(HttpServletRequest request) {
        String id = request.getSession().getId();
        System.out.println("sessionId:" + id);
        return interlibService.getSessionId();
    }
}
