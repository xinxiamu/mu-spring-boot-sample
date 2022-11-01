package com.luo.demo.j2cache.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试对象
 *
 * @author luohq
 * @date 2022-04-03 13:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyObjInner {
    private Long id;
    private String name;
}
