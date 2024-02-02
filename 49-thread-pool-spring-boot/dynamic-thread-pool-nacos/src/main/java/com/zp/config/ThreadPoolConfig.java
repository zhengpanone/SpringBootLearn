package com.zp.config;

import com.zp.model.ThreadPoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;


/**
 * Author : zhengpanone
 * Date : 2024/2/2 11:13
 * Version : v1.0.0
 * Description: 线程池
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Autowired
    private ThreadPoolProperties properties;

    private ThreadPoolTaskExecutor executor;


    @Bean
    public ExecutorService getThreadPool() {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
//        return Executors.newCachedThreadPool();
    }

    /**
     * 下面的配置是配置Springboot的@Async注解所用的线程池
     */


    @Bean
    public Executor taskExecutor() {
        executor = new ThreadPoolTaskExecutor();
        /*// 线程池核心容量
        executor.setCorePoolSize(properties.getCoreSize());
        // 线程池最大容量
        executor.setMaxPoolSize(properties.getMaxSize());
        // 任务队列长度
        executor.setQueueCapacity(properties.getQueueCapacity());
        // 线程超时时间
        executor.setKeepAliveSeconds(60);
        // 设置线程名称前缀
        executor.setThreadNamePrefix("test-async-pool-");
        // 设置任务丢弃后的处理策略,当poolSize已达到maxPoolSize，如何处理新任务（是拒绝还是交由其它线程处理）,
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
*/
        // executor.initialize();
        updateThreadPoolExecutor(properties);
        return executor;
    }

    /**
     * 细粒度控制：这种方法允许对特定的配置项进行细粒度的更新，而不是刷新整个Bean。
     * 性能：相比于@RefreshScope可能导致的重建Bean，这种方法只更新需要变更的配置项，可能对性能影响较小。
     */
    @EventListener(RefreshScopeRefreshedEvent.class)
    public void onRefresh(RefreshScopeRefreshedEvent event) {
        updateThreadPoolExecutor(properties);
    }


    private void updateThreadPoolExecutor(ThreadPoolProperties poolProperties) {

        System.out.println("更新线程池配置");
        /*if (executor != null) {
            // 关闭现有的线程池
            shutdownAwaitTermination(executor.getThreadPoolExecutor());
        }*/
        // 使用新的配置参数并初始化一个新的线程池实例
        // ThreadPoolTaskExecutor newExecutor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(poolProperties.getCoreSize());
        executor.setMaxPoolSize(poolProperties.getMaxSize());
        executor.setQueueCapacity(poolProperties.getQueueCapacity());
        executor.setThreadNamePrefix("custom-executor-");
        executor.initialize();
        // 更新引用，使用新的线程池实例
        // this.executor = newExecutor;
    }


    private void shutdownAwaitTermination(Executor executor) {
        if (executor instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPool = (ThreadPoolExecutor) executor;
            threadPool.shutdown();// 禁止提交新任务
            try {
                // 等待一段时间以终止现有任务
                if (!threadPool.awaitTermination(30, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow(); // 取消当前正在执行的任务
                    // 等待一段时间，等待任务对取消做出响应
                    if (!threadPool.awaitTermination(30, TimeUnit.SECONDS)) {
                        System.out.println("线程池未完全终止");
                    }
                }
            } catch (InterruptedException e) {
                // （重新-）如果当前线程也中断，则取消
                threadPool.shutdownNow();
                // 保留中断状态
                Thread.currentThread().interrupt();
            }
        }
    }


}
