package com.luo.demo.j2cache.l2.lettuce;

import com.luo.demo.j2cache.base.J2CacheBaseSample;
import lombok.extern.slf4j.Slf4j;

/**
 * J2cache L1 Caffeine, L2 Redis(Lettuce)缓存示例
 *
 * @author luohq
 * @date 2022-04-03 11:57
 */
@Slf4j
public class L1CaffeineL2LettuceSample2 {
    public static void main(String[] args) throws Exception {
        String j2CachePropsPath = "/j2cache-l1-caffeine-l2-lettuce.properties";
        J2CacheBaseSample j2CacheBaseSample = new J2CacheBaseSample(j2CachePropsPath);
        j2CacheBaseSample.test2(J2CacheBaseSample.DEFAULT_REGION, J2CacheBaseSample.DEFAULT_KEY1);
    }
}
