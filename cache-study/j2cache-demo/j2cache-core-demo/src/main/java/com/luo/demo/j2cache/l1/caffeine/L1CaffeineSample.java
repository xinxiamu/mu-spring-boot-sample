package com.luo.demo.j2cache.l1.caffeine;

import com.luo.demo.j2cache.base.J2CacheBaseSample;
import lombok.extern.slf4j.Slf4j;

/**
 * J2cache L1 Caffeine缓存示例
 *
 * @author luohq
 * @date 2022-04-03 11:57
 */
@Slf4j
public class L1CaffeineSample {
    public static void main(String[] args) throws Exception {
        String j2CachePropsPath = "/j2cache-l1-caffeine.properties";
        J2CacheBaseSample j2CacheBaseSample = new J2CacheBaseSample(j2CachePropsPath);
        j2CacheBaseSample.test();
    }
}
