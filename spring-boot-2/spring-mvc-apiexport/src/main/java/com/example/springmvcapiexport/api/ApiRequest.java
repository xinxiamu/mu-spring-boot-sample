package com.example.springmvcapiexport.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author lujijiang
 */
public class ApiRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -81070875483237596L;
    /**
     * 回调ID
     */
    String id;
    /**
     * 请求令牌
     */
    String token;
    /**
     * 服务名
     */
    String name;
    /**
     * 服务参数
     */
    Object[] args;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", args=" + Arrays.toString(args) + "]";
    }

}
