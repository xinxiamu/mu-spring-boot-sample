
## 一、J2Cache Core示例

### 1. L1 Caffeine示例
核心代码：[j2cache-core-demo/../l1/caffeine/L1CaffeineSample.java](j2cache-core-demo/src/main/java/com/luo/demo/j2cache/l1/caffeine/L1CaffeineSample.java)<br/>
配置文件：[j2cache-core-demo/../resources/j2cache-l1-caffeine.properties](j2cache-core-demo/src/main/resources/j2cache-l1-caffeine.properties)


### 2. L1 Caffeine + JGroups示例
核心代码：[j2cache-core-demo/../l1/jgroups/L1CaffeineJGroupsSample.java | L1CaffeineJGroupsSample2.java](j2cache-core-demo/src/main/java/com/luo/demo/j2cache/l1/jgroups)<br/>
配置文件：<br/>
[j2cache-core-demo/../resources/j2cache-l1-caffeine-jgroups.properties](j2cache-core-demo/src/main/resources/j2cache-l1-caffeine-jgroups.properties)<br/>
[j2cache-core-demo/../resources/network.xml](j2cache-core-demo/src/main/resources/network.xml)

### 3. L1 Caffeine, L2 Redis(Jedis)示例
核心代码：[j2cache-core-demo/../l2/redis/L1CaffeineL2RedisSample.java | L1CaffeineL2RedisSample2.java](j2cache-core-demo/src/main/java/com/luo/demo/j2cache/l2/redis)<br/>
配置文件：[j2cache-core-demo/../resources/j2cache-l1-caffeine-l2-redis.properties](j2cache-core-demo/src/main/resources/j2cache-l1-caffeine-l2-redis.properties)

### 4. L1 Caffeine, L2 Redis(Lettuce)示例
核心代码：[j2cache-core-demo/../l2/redis/L1CaffeineL2LettuceSample.java | L1CaffeineL2LettuceSample2.java](j2cache-core-demo/src/main/java/com/luo/demo/j2cache/l2/lettuce)<br/>
配置文件：[j2cache-core-demo/../resources/j2cache-l1-caffeine-l2-lettuce.properties](j2cache-core-demo/src/main/resources/j2cache-l1-caffeine-l2-lettuce.properties)



## 二、J2Cache SpringBoot + Spring Cache集成示例
>**注：** 具体执行可参见测试用例：[j2cache-spring-cache-demo/../test../J2cacheDemoApplicationTests.java](j2cache-spring-cache-demo/src/test/java/com/luo/demo/j2cache/J2cacheDemoApplicationTests.java)<br/>
### 1. Jedis集成
核心代码：[j2cache-spring-cache-demo](j2cache-spring-cache-demo)<br/>
配置文件：<br/>
[j2cache-spring-cache-demo/../resources/application-jedis.yml](j2cache-spring-cache-demo/src/main/resources/application-jedis.yml)<br/>
[j2cache-spring-cache-demo/../resources/j2cache-redis.properties](j2cache-spring-cache-demo/src/main/resources/j2cache-redis.properties)

### 2. Lettuce集成
核心代码：[j2cache-spring-cache-demo](j2cache-spring-cache-demo)<br/>
配置文件：<br/>
[j2cache-spring-cache-demo/../resources/application-lettuce.yml](j2cache-spring-cache-demo/src/main/resources/application-lettuce.yml)<br/>
[j2cache-spring-cache-demo/../resources/j2cache-redis.properties](j2cache-spring-cache-demo/src/main/resources/j2cache-redis.properties)


## 三、自定义J2Cache SpringBoot Starter（使用Spring Data Redis配置）
>由于直接使用社区提供的j2cache-spring-boot2-starter是将j2cache.properties的配置转换为Spring Data Redis配置，<br/>
>即读取j2cache.properties中的redis属性再转换为Spring Data Redis相关对象（JedisConnectionFactory, LettuceConnectionFactory）,<br/>
>本示例将该starter进行重构，重构后的starter`直接使用Spring Data Redis相关配置及对象`，无需再通过单独的j2cache.properties进行配置及构造，<br/>
>同时对J2Cache的配置进行了提取与封装，可以基于SpringBoot生态`application.yml`等直接进行配置，<br/>
>并复用了原starter关于`RedisSerializer、MessageListener、SpringRedisProvider、J2CacheCacheManager`等实现。

![J2Cache Spring Redis Architecture Diagram](doc/J2cache%20Spring%20Redis.png)

### 1. j2cache-native-spring-boot-starter
核心代码：[j2cache-spring-cache-native-demo/j2cache-native-spring-boot-starter](j2cache-spring-cache-native-demo/j2cache-native-spring-boot-starter)<br/>
配置文件格式：
```yaml
spring:
  # Spring Data Redis配置
  redis:
    client-type: lettuce
    host: 127.0.0.1
    port: 6379
    password:
    database: 0
    # lettuce连接池配置
    lettuce:
      pool:
        enabled: true
        max-active: 8
        max-idle: 8
        min-idle: 5
        time-between-eviction-runs: 30s
        max-wait: 5s
      shutdown-timeout: 100ms
# J2Cache配置
j2cache:
  # 开启J2Cache支持Spring Cache
  open-spring-cache: true
  # 缓存清除模式（active | passive | blend）
  cache-clean-mode: passive
  # 缓存变更广播方式（jgroups | redis | lettuce | rabbitmq | rocketmq | none | 自定义class）
  # 保持默认SpringBoot Redis自定义实现SpringRedisPubSubPolicy
  broadcast: com.luo.j2cache.sb.cache.support.redis.SpringRedisPubSubPolicy
  # 缓存null对象
  default-cache-null-object: true
  # L1缓存配置
  l1:
    # L1 缓存provider名称（caffeine | ehcache | ehcache3）
    provider-class: caffeine
    # Caffeine配置
    caffeine:
      region:
        default: 100,10m
        myRegion: 10,5m
  # L2缓存配置
  l2:
    # L2 缓存provider名称（redis | lettuce | readonly-redis | memcached）
    # 保持默认SpringBoot Redis自定义实现SpringRedisProvider
    provider-class: com.luo.j2cache.sb.cache.support.redis.SpringRedisProvider
    # 二级缓存序列化格式（fst（推荐） | kryo | json | fastjson | java（默认） | fse | 自定义classname）
    serialization: fastjson
    redis:
      # 是否启用同步一级缓存的Time-To-Live超时时间到Redis TTL（true启用，false不启用则永不超时）
      sync-ttl-to-redis: true
      # Redis发布订阅（Pub/Sub）对应的channel名称
      channel: j2cache
      #  Key命名空间（前缀），默认为空
      namespace: myName
#  兼容原J2Cache属性配置（即原来需要放到j2cache.properties中的属性皆可直接在此配置）
#  默认使用redis则无需此配置  
#  properties: 
#    caffeine.region.myRegion: 100,5m
#    redis.mode: single
```
### 2.  j2cache-native-spring-boot-starter集成示例
核心代码：[j2cache-spring-cache-native-demo/j2cache-native-spring-boot-demo](j2cache-spring-cache-native-demo/j2cache-native-spring-boot-demo)<br/>
配置文件：[j2cache-spring-cache-native-demo/j2cache-native-spring-boot-demo/../resources/application.yml](j2cache-spring-cache-native-demo/j2cache-native-spring-boot-demo/src/main/resources/application.yml)<br/>