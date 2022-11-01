package com.luo.demo.j2cache.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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
public class MyObj {
    private Long id;
    private String name;
    private Integer num;
    private Date date;
    private LocalDateTime localDateTime;
}
