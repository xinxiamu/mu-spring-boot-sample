package com.example.demo.test1;

import com.example.demo.Result;

public interface InterlibService {

    /**
     * 获取interlib的SessionId
     * @return
     */
    Result<String> getSessionId();
}
