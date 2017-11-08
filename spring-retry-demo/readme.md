在Spring Boot中使用Spring Retry
https://github.com/spring-projects/spring-retry

介绍一下几个注解

@EnableRetry能否重试。当proxyTargetClass属性为true时，使用CGLIB代理。默认使用标准JAVA注解。在spring Boot中此参数写在程序入口即可。
@Retryable 标注此注解的方法在发生异常时会进行重试
            value：指定处理的异常类

            include：指定处理的异常类和value一样，默认为空，当exclude也为空时，默认所有异常

            exclude：指定异常不处理，默认空，当include也为空时，默认所有异常

            maxAttempts：最大重试次数。默认3次

            backoff： 重试等待策略。默认使用@Backoff注解

@Backoff 重试等待策略
            不设置参数时，默认使用FixedBackOffPolicy（指定等待时间），重试等待1000ms

            设置delay,使用FixedBackOffPolicy（指定等待时间），重试等待填写的时间

            设置delay和maxDealy时，重试等待在这两个值之间均态分布

          设置delay、maxDealy、multiplier，使用 ExponentialBackOffPolicy（指数级重试间隔的实现 ），multiplier即指定延迟倍数，比如delay=5000l,multiplier=2,则第一次重试为5秒，第二次为10秒，第三次为20秒……

@Recover 用于@Retryable重试失败后处理方法，此注解注释的方法参数一定要是@Retryable抛出的异常，否则无法识别，可以在该方法中进行日志处理。