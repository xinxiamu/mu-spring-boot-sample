package com.luo.demo.j2cache.l1.jgroups;

import com.luo.demo.j2cache.base.J2CacheBaseSample;
import lombok.extern.slf4j.Slf4j;

/**
 * J2cache L1 Caffeine 且集成JGroups广播通知 缓存示例
 *
 * @author luohq
 * @date 2022-04-03 11:57
 */
@Slf4j
public class L1CaffeineJGroupsSample2 {
    public static void main(String[] args) throws Exception {
        String j2CachePropsPath = "/j2cache-l1-caffeine-jgroups.properties";
        J2CacheBaseSample j2CacheBaseSample = new J2CacheBaseSample(j2CachePropsPath);
        j2CacheBaseSample.test2(J2CacheBaseSample.DEFAULT_REGION, J2CacheBaseSample.DEFAULT_KEY1);
    }
}
