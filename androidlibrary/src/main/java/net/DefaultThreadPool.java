package net;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class DefaultThreadPool {

        public static ThreadPoolExecutor executor = null;

        private int corePoolSize;
        private int maximumPoolSize;
        private long keepAliveTime = 0; // 限制线程的的最大存活时间
        public DefaultThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime)
        {
            this.corePoolSize = corePoolSize;  //核心线程数
            this.maximumPoolSize = maximumPoolSize; //最大线程 ，当核心线程用完时。决定是否开启最大线程
            this.keepAliveTime = keepAliveTime;  //线程排队时间，
        }

        public void execute(Runnable runnable)
        {
            if (runnable == null)
            {
                return;
            }

            if (executor == null)
            {

                executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                        TimeUnit.MILLISECONDS,// 时间单位
                        new LinkedBlockingQueue<Runnable>(),// 线程队列
                        Executors.defaultThreadFactory(),//线程工厂
                        new ThreadPoolExecutor.AbortPolicy());
            }
            // 给线程池里面添加一个线程
            executor.execute(runnable);
        }

    }




